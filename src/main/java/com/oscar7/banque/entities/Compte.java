package com.oscar7.banque.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Compte implements Serializable {
    @Id
    String codeCompte;
    Date dateCreation;
    double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    Client client;
    @OneToMany(mappedBy = "compte")
    Collection<Operation> operations;

    public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
        super();
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }
}
