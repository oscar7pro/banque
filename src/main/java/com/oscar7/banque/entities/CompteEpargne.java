package com.oscar7.banque.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
    double taux;

    public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, Collection<Operation> operations, double taux) {
        super(codeCompte, dateCreation, solde, client, operations);
        this.taux = taux;
    }

    public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
        super(codeCompte, dateCreation, solde, client);
        this.taux = taux;
    }
}
