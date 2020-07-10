package com.oscar7.banque.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Operation implements Serializable {
   @Id @GeneratedValue
    Long numero;
    Date dateOperation;
    double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    Compte compte;

 public Operation(Date dateOperation, double montant, Compte compte) {
  super();
  this.dateOperation = dateOperation;
  this.montant = montant;
  this.compte = compte;
 }
}
