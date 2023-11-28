package com.geoinfo.TransactionApp.services;

import com.geoinfo.TransactionApp.dtos.AnnonceDemandesResponse;
import com.geoinfo.TransactionApp.entities.User_role.Intermediaire;
import com.geoinfo.TransactionApp.entities.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    public void ajouter_utilisateur(Utilisateur utilisateur);

    public void supprimer_utilisateur(Long id);

    public void modifier_utilisateur(Utilisateur utilisateur,Long id);

    Utilisateur get_utilisateur(Long id);

    List<Utilisateur> getAllUtilisateur();

    List<Intermediaire> getAllIntermediaire();

    public void ajouter_intermediaire(Intermediaire intermediaire);

    public Utilisateur login(String email,String password);

    public List<AnnonceDemandesResponse> citoyens_demandeur(long annonce_id);





}
