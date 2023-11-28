package com.geoinfo.TransactionApp.services;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.entities.Demande;
import com.geoinfo.TransactionApp.entities.User_role.Citoyen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeService {

    public void ajouter_demande(Demande demande);

    public void supprimer_demande(Long id);

    public void modifier_demande(Demande demande,Long id);

    List<Demande> getAllDemandes(Annonce annonce);

    Demande getDemande(Long id);

    public void faire_demande_pour_annonce(long id_annonce, Citoyen utilisateur_demandeur);

    List<Demande> demandes_for_annonce(long annonce_id);

}
