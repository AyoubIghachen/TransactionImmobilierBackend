package com.geoinfo.TransactionApp.reposirory;

import com.geoinfo.TransactionApp.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Utilisateur findUtilisateurById(Long id);

    Utilisateur findUtilisateurByEmailAndPassword(String email,String password);



}
