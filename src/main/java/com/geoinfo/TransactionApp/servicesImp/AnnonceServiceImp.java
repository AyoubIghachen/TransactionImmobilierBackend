package com.geoinfo.TransactionApp.servicesImp;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.enums.BienType;
import com.geoinfo.TransactionApp.enums.Etat;
import com.geoinfo.TransactionApp.enums.OperationType;
import com.geoinfo.TransactionApp.enums.Statut;
import com.geoinfo.TransactionApp.reposirory.AnnonceRepository;
import com.geoinfo.TransactionApp.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnnonceServiceImp implements AnnonceService {

    @Autowired()
    AnnonceRepository annonceRepository;
    @Override
    public void ajouterAnnonce(Annonce annonce) {
        annonce.setDate_annonce(new Date());
        annonceRepository.save(annonce);
    }

    @Override
    public void supprimerAnnonce(long id) {
        annonceRepository.deleteById(id);

    }

    @Override
    public void modifierAnnonce(Annonce annonce, long id) {
    }

    @Override
    public List<Annonce> getAllAnnonce() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce getAnnonce(long id) {
        return annonceRepository.findById(id).get();
    }

    @Override
    public void reserverAnnonce(long Id_intermediaire, long Id_annonce) {
        Annonce annonce=getAnnonce(Id_annonce);
        annonce.setIntermediaire_id(Id_intermediaire);
        annonce.setStatut(Statut.RESERVEE);
        annonceRepository.save(annonce);
    }

    @Override
    public void libererAnnonce( long Id_annonce) {
        Annonce annonce =getAnnonce(Id_annonce);
        annonce.setStatut(Statut.EN_ATTENTE);
        annonce.setEtat(Etat.NULL);
        annonce.setMotif_rejet(null);
        annonce.setIntermediaire_id(-1);
        annonceRepository.save(annonce);
    }

    @Override
    public List<Annonce> getAlAnnoncesReseverByIntermediaire(long id) {
        List<Annonce> A_Inter =annonceRepository.findByIntermediaireId(id);
        List<Annonce> Annonce_inter_reserve=new ArrayList<>();
        for(int i=0;i<A_Inter.size();i++){
            if(A_Inter.get(i).getStatut().equals(Statut.RESERVEE) && !(A_Inter.get(i).getEtat().equals(Etat.REJETER))){
                Annonce_inter_reserve.add(A_Inter.get(i));
            }
        }
        return Annonce_inter_reserve ;
    }

    @Override
    public List<Annonce> getAlAnnoncesRejeterByIntermediaire(long Id_intermediare) {
        List<Annonce> A_Inter =annonceRepository.findByIntermediaireId(Id_intermediare);
        List<Annonce> Annonce_inter_rejeter=new ArrayList<>();
        for(int i=0;i<A_Inter.size();i++){
            if(A_Inter.get(i).getStatut().equals(Statut.RESERVEE) && A_Inter.get(i).getEtat().equals(Etat.REJETER)){
                Annonce_inter_rejeter.add(A_Inter.get(i));
            }
        }
        return Annonce_inter_rejeter ;
    }

    @Override
    public List<Annonce> getAllAnnoncesRejeteForCitoyen(long Id_citoyen) {
        return null;
    }

    @Override
    public void PublierAnnonce(long AnnonceID) {
        Annonce annonce=getAnnonce(AnnonceID);
        if(annonce.getStatut().equals(Statut.RESERVEE)){
            annonce.setEtat(Etat.PUBLIEE);
            annonceRepository.save(annonce);
        }
    }
    /*
    @Override
    public void RejeterAnnonce(long AnnonceID) {
        Annonce annonce=getAnnonce(AnnonceID);
        if(annonce.getStatut().equals(Statut.RESERVEE)){
            annonce.setEtat(Etat.REJETER);
            annonceRepository.save(annonce);
        }

    }

     */

    @Override
    public void RejeterAnnonce(long AnnonceID, String motifRejet) {
        Annonce annonce = getAnnonce(AnnonceID);
        if (annonce.getStatut().equals(Statut.RESERVEE)) {
            annonce.setEtat(Etat.REJETER);
            annonce.setMotif_rejet(motifRejet); // Mettre à jour le motif de rejet
            annonceRepository.save(annonce);
        }
    }

    @Override
    public List<Annonce> getAllAnnoncesPasEncoreReserve() {
        List<Annonce> annoces=annonceRepository.findAll();
        List<Annonce> Annonce_not_reserve=new ArrayList<>();
        for(int i=0;i<annoces.size();i++) {
            if (annoces.get(i).getStatut().equals(Statut.EN_ATTENTE)) {
                Annonce_not_reserve.add(annoces.get(i));
            }
        }
        return Annonce_not_reserve;
    }

    @Override
    public List<Annonce> getAllAnnoncesPublie() {
        List<Annonce> annoces=annonceRepository.findAll();
        List<Annonce> Annonce_publie=new ArrayList<>();
        for(int i=0;i<annoces.size();i++) {
            if (annoces.get(i).getEtat().equals(Etat.PUBLIEE)) {
                Annonce_publie.add(annoces.get(i));
            }
        }
        return Annonce_publie;
    }

    @Override
    public List<List<Annonce>> getAnnoncesByPriceCategories() {
        Double minPrice = annonceRepository.findMinPrice();
        Double maxPrice = annonceRepository.findMaxPrice();

        // Calcul des intervalles de prix
        double range = (maxPrice - minPrice) / 5;
        double currentMin = minPrice;
        double currentMax = minPrice + range;

        // Création de cinq catégories
        List<List<Annonce>> priceCategories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Annonce> category = new ArrayList<>();
            for (Annonce annonce : annonceRepository.findAll()) {
                double price = annonce.getPrix_bien();
                if (annonce.getEtat().equals(Etat.PUBLIEE) && price >= currentMin && price <= currentMax) {
                    category.add(annonce);
                }
            }
            priceCategories.add(category);
            currentMin = currentMax;
            currentMax += range;
        }

        return priceCategories;
    }

    @Override
    public List<List<Annonce>> getAnnoncesBySurfaceCategories() {
        Double minSurface = annonceRepository.findMinSurface();
        Double maxSurface = annonceRepository.findMaxSurface();

        // Calcul des intervalles de prix
        double range = (maxSurface - minSurface) / 5;
        double currentMin = minSurface;
        double currentMax = minSurface + range;

        // Création de cinq catégories
        List<List<Annonce>> SurfaceCategories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Annonce> category = new ArrayList<>();
            for (Annonce annonce : annonceRepository.findAll()) {
                double surface = annonce.getSurface();
                if (annonce.getEtat().equals(Etat.PUBLIEE) && surface >= currentMin && surface <= currentMax) {
                    category.add(annonce);
                }
            }
            SurfaceCategories.add(category);
            currentMin = currentMax;
            currentMax += range;
        }

        return SurfaceCategories;
    }

    @Override
    public List<Annonce> getAnnonceOperation(OperationType operationType) {
        return annonceRepository.AnnoncePublieTypeOperation(operationType,Etat.PUBLIEE);
    }


    @Override
    public List<Annonce> getAnnonceTypeBien(BienType bienType) {
        return annonceRepository.AnnoncePublieTypeBien(bienType,Etat.PUBLIEE);
    }

}
