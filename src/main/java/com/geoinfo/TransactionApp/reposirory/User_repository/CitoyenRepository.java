package com.geoinfo.TransactionApp.reposirory.User_repository;

import com.geoinfo.TransactionApp.entities.User_role.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitoyenRepository extends JpaRepository<Citoyen,Long> {

    @Query("SELECT COUNT(citoyen) FROM Citoyen citoyen")
    int countTotalCitoyens();

    Citoyen findCitoyenById(Long id);
}
