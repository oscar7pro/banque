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
@DiscriminatorValue("V")
public class Versement extends Operation{
    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
