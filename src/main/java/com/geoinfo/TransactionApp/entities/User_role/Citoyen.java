package com.geoinfo.TransactionApp.entities.User_role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.entities.Demande;
import com.geoinfo.TransactionApp.entities.Utilisateur;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Citoyen extends Utilisateur   {
    private String telephone;
    private String ime;

    @JsonIgnore
    @OneToMany(mappedBy = "annonceur",fetch = FetchType.LAZY)
    private Collection<Annonce> annonces ;

    //@JsonIgnore
    @JsonIgnore
    @OneToMany(mappedBy = "demandeur",fetch = FetchType.LAZY)
    private Collection<Demande> demandes ;
}
