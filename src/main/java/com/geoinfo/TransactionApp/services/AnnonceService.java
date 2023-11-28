package com.geoinfo.TransactionApp.services;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.enums.BienType;
import com.geoinfo.TransactionApp.enums.Etat;
import com.geoinfo.TransactionApp.enums.OperationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnonceService {

    public void ajouterAnnonce(Annonce annonce);

    public void supprimerAnnonce(long id);

    public void modifierAnnonce(Annonce annonce ,long id);

    List<Annonce> getAllAnnonce();

    Annonce getAnnonce(long id);

    public void reserverAnnonce(long Id_intermediaire,long Id_annonce);

    public void libererAnnonce(long Id_annonce);

    List<Annonce> getAlAnnoncesReseverByIntermediaire(long Id_intermediare) ;

    List<Annonce> getAlAnnoncesRejeterByIntermediaire(long Id_intermediare) ;

    List<Annonce> getAllAnnoncesRejeteForCitoyen(long Id_citoyen);

    public void PublierAnnonce(long AnnonceID);

    public void RejeterAnnonce(long AnnonceID,String motifRejet);

    List<Annonce> getAllAnnoncesPasEncoreReserve();

    List<Annonce> getAllAnnoncesPublie();

    public List<List<Annonce>> getAnnoncesByPriceCategories();

    public List<List<Annonce>> getAnnoncesBySurfaceCategories();

    List<Annonce> getAnnonceOperation(OperationType operationType);

    List<Annonce> getAnnonceTypeBien(BienType bienType);














}
