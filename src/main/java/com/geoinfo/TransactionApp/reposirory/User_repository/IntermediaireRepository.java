package com.geoinfo.TransactionApp.reposirory.User_repository;

import com.geoinfo.TransactionApp.entities.User_role.Intermediaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IntermediaireRepository extends JpaRepository<Intermediaire,Long> {

    @Query("SELECT COUNT(inter) FROM Intermediaire inter")
    int countTotalIntermediaires();


    @Override
    List<Intermediaire> findAll();
}
