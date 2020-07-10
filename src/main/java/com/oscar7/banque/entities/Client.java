package com.oscar7.banque.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Client  implements Serializable {
    @Id @GeneratedValue
    Long code;
    String nom;
    String email;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    Collection<Compte> comptes;

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
}
