package com.geoinfo.TransactionApp.controllers;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistiques")
public class StatistiqueController {

    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping("/Nb_Totale_annonces")
    int CountAnnocesTotale(){
        return statistiqueService.nombre_totale_annonces() ;
    }

    @GetMapping("/Nb_Totale_demandes")
    int CountDemandesTotale(){
        return statistiqueService.nombre_totale_demande() ;
    }

    @GetMapping("/Nb_Totale_intermediaires")
    int CountTotaleIntermediaires(){
        return statistiqueService.nombre_totale_intermediaire() ;
    }

    @GetMapping("/Nb_Totale_citoyens")
    int CountTotaleCitoyens(){
        return statistiqueService.nombre_totale_citoyen() ;
    }
}
