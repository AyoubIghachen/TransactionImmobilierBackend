package com.geoinfo.TransactionApp.reposirory;


import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.enums.BienType;
import com.geoinfo.TransactionApp.enums.Etat;
import com.geoinfo.TransactionApp.enums.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {

    List<Annonce> findByDescriptionContaining(String mc);
    @Query("select a from Annonce a where a.description like :x")
    List<Annonce> search(@Param("x")String mc);

    @Query("SELECT COUNT(a) FROM Annonce a")
    int countTotalAnnonces();

    @Query("SELECT a FROM Annonce a WHERE a.intermediaire_id = :intermediaireId")
    List<Annonce> findByIntermediaireId(@Param("intermediaireId") long intermediaireId);

    @Query("SELECT MIN(a.prix_bien) FROM Annonce a")
    Double findMinPrice();

    @Query("SELECT MAX(a.prix_bien) FROM Annonce a")
    Double findMaxPrice();

    @Query("SELECT MIN(a.surface) FROM Annonce a")
    Double findMinSurface();

    @Query("SELECT MAX(a.surface) FROM Annonce a")
    Double findMaxSurface();

    @Query("SELECT a FROM Annonce a WHERE a.type_operation = :type_achat AND a.etat = :etat")
    List<Annonce> AnnoncePublieTypeOperation(@Param("type_achat") OperationType type_achat, @Param("etat") Etat etat);

    @Query("SELECT a FROM Annonce a WHERE a.type_bien = :type_bien AND a.etat = :etat")
    List<Annonce> AnnoncePublieTypeBien(@Param("type_bien") BienType type_bien, @Param("etat") Etat etat);








    /*
    List<Annonce> findByCitoyenId(long id);

    List<Annonce> findAnnoncesByIntermediaire_id(long id);
     */




}
