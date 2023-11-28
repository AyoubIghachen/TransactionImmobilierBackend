package com.geoinfo.TransactionApp.entities.User_role;

import com.geoinfo.TransactionApp.entities.Utilisateur;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Intermediaire extends Utilisateur {
    public Intermediaire() {
        super();
    }
}
