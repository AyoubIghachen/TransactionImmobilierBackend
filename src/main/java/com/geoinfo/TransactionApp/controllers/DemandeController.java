package com.geoinfo.TransactionApp.controllers;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.entities.Demande;
import com.geoinfo.TransactionApp.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService ;

    @PostMapping
    public void ajouter_demande(@RequestBody Demande demande){
        demandeService.ajouter_demande(demande);
    }

    @DeleteMapping("/{id}")
    public void supprimer_demande(@PathVariable Long id){
        demandeService.supprimer_demande(id);
    }
    @PutMapping("/{id}")
    public void modifier_demande(@RequestBody Demande demande,@PathVariable Long id){
        demandeService.modifier_demande(demande,id);
    }
    @GetMapping("/demandes_for_annonce")
    List<Demande> liste_demande(Annonce annonce){
       return demandeService.getAllDemandes(annonce);
    }

    Demande get_demande(Long id){
        return demandeService.getDemande(id);
    }

    @GetMapping("/demandes_for_annonce/{annonce_id}")
    List<Demande> liste_demade_pour_annonce(@PathVariable Long annonce_id){
        return demandeService.demandes_for_annonce(annonce_id);
    }
}
