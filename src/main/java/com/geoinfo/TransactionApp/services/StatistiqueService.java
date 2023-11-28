package com.geoinfo.TransactionApp.services;

import org.springframework.stereotype.Service;

@Service
public interface StatistiqueService {

    public int nombre_totale_annonces();

    public int nombre_totale_demande();

    public int nombre_totale_intermediaire();

    public int nombre_totale_citoyen();

}
