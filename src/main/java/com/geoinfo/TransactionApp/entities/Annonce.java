package com.geoinfo.TransactionApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geoinfo.TransactionApp.entities.User_role.Citoyen;
import com.geoinfo.TransactionApp.enums.BienType;
import com.geoinfo.TransactionApp.enums.Etat;
import com.geoinfo.TransactionApp.enums.OperationType;
import com.geoinfo.TransactionApp.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Size;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Annonce  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longitude ;

    private String latitude;

    private Double surface;

    @Enumerated(EnumType.STRING)
    private BienType type_bien;

    private Double prix_bien;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date_annonce;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    private OperationType type_operation;

    private String description;

    private String motif_rejet;

    private int delai;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    private long intermediaire_id;

    @JsonIgnore
    @OneToMany(mappedBy = "annonce",fetch = FetchType.LAZY)
    private Collection<Demande> demandeForAnnonce ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Citoyen annonceur;


    @Size(max = 2500)
    private String photo;


}
