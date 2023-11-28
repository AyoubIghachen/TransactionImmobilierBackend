package com.geoinfo.TransactionApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geoinfo.TransactionApp.entities.User_role.Citoyen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Demande {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Annonce annonce;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date_demande;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Citoyen demandeur;


}
