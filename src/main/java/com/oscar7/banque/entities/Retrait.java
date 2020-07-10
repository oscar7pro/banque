package com.oscar7.banque.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

//@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{
    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
