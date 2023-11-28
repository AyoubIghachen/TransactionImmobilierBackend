package com.geoinfo.TransactionApp.servicesImp;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.entities.Demande;
import com.geoinfo.TransactionApp.entities.User_role.Citoyen;
import com.geoinfo.TransactionApp.reposirory.DemandeRepository;
import com.geoinfo.TransactionApp.reposirory.UtilisateurRepository;
import com.geoinfo.TransactionApp.services.AnnonceService;
import com.geoinfo.TransactionApp.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DemandeServiceImp implements DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private AnnonceService  annonceService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void ajouter_demande(Demande demande){
        demande.setDate_demande(new Date());
        demandeRepository.save(demande);
    }

    @Override
    public void supprimer_demande(Long id) {
        demandeRepository.deleteById(id);
    }
    @Override
    public void modifier_demande(Demande demande, Long id) {

    }

    @Override
    public List<Demande> getAllDemandes(Annonce annonce) {
        return null;
    }

    @Override
    public Demande getDemande(Long id) {
        return demandeRepository.findById(id).get();
    }

    @Override
    public void faire_demande_pour_annonce(long id_annonce, Citoyen utilisateur_demandeur) {
        Annonce annonce=annonceService.getAnnonce(id_annonce);
        Demande demande=new Demande();
        demande.setAnnonce(annonce);
        demande.setDemandeur(utilisateur_demandeur);
        demandeRepository.save(demande);

    }

    @Override
    public List<Demande> demandes_for_annonce(long id_annonce) {
        Annonce annonce=annonceService.getAnnonce(id_annonce);
        return demandeRepository.findDemandesByAnnonce(annonce);
    }

}
