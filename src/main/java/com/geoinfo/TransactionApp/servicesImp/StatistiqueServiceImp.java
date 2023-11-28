package com.geoinfo.TransactionApp.servicesImp;

import com.geoinfo.TransactionApp.reposirory.AnnonceRepository;
import com.geoinfo.TransactionApp.reposirory.DemandeRepository;
import com.geoinfo.TransactionApp.reposirory.User_repository.CitoyenRepository;
import com.geoinfo.TransactionApp.reposirory.User_repository.IntermediaireRepository;
import com.geoinfo.TransactionApp.reposirory.UtilisateurRepository;
import com.geoinfo.TransactionApp.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatistiqueServiceImp implements StatistiqueService{

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private IntermediaireRepository intermediaireRepository;

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Override
    public int nombre_totale_annonces() {
        return annonceRepository.countTotalAnnonces();
    }

    @Override
    public int nombre_totale_demande() {
        return demandeRepository.countTotalDemandes();
    }

    @Override
    public int nombre_totale_intermediaire() {
        return intermediaireRepository.countTotalIntermediaires();
    }

    @Override
    public int nombre_totale_citoyen() {
        return citoyenRepository.countTotalCitoyens();
    }
}
