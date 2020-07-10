package com.oscar7.banque.dao;

import com.oscar7.banque.entities.Client;
import com.oscar7.banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String> {
}
