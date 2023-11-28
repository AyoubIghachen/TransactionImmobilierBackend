package com.geoinfo.TransactionApp.controllers;

import com.geoinfo.TransactionApp.dtos.AnnonceDemandesResponse;
import com.geoinfo.TransactionApp.dtos.LoginRequest;
import com.geoinfo.TransactionApp.entities.User_role.Intermediaire;
import com.geoinfo.TransactionApp.entities.Utilisateur;
import com.geoinfo.TransactionApp.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public void Ajouter_utilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurService.ajouter_utilisateur(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void Supprimer_utilisateur(@PathVariable Long id){
        utilisateurService.supprimer_utilisateur(id);
    }

    @PutMapping("/{id}")
    public void Modifier_utilisateur(@RequestBody Utilisateur utilisateur,@PathVariable Long id){
        utilisateurService.modifier_utilisateur(utilisateur,id);
    }

    @GetMapping("/{id}")
    Utilisateur Get_utilisateur(@PathVariable Long id){
        return utilisateurService.get_utilisateur(id);
    }

    @GetMapping
    List<Utilisateur> GetAllUtilisateur(){
      return utilisateurService.getAllUtilisateur();
    }

    @GetMapping("/intermediaires")
    List<Intermediaire> GetAllIntermediaires(){
        return utilisateurService.getAllIntermediaire();
    }

    @PostMapping("/intermediaires")
    public void Ajouter_intermediaire( @RequestBody Intermediaire intermediaire){
        utilisateurService.ajouter_intermediaire(intermediaire);
    }

    @PostMapping("/login")
    public Utilisateur Login(@RequestBody LoginRequest request){
        return utilisateurService.login(request.getEmail(), request.getPassword());
    }

    @GetMapping("/citoyen_demandeur/{id}")
    public List<AnnonceDemandesResponse> Citoyen_demandeur(@PathVariable Long id){
        return utilisateurService.citoyens_demandeur(id);
    }
}
