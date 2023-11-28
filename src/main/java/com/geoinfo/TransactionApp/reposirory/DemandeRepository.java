package com.geoinfo.TransactionApp.reposirory;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande,Long> {

    /*
    @Query("SELECT d FROM Demande d WHERE d.annonce.citoyen_id = :citoyenId")
    List<Demande> findByCitoyenId(@Param("citoyenId") Long citoyenId);

     */

    List<Demande> findAllByAnnonce(Annonce annonce);

    @Query("SELECT COUNT(d) FROM Demande d")
    int countTotalDemandes();


    @Query("SELECT d FROM Demande d")
    List<Demande> findAlldemande();

    List<Demande> findDemandesByAnnonce(Annonce annonce);

}
