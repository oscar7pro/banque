package com.oscar7.banque.dao;

import com.oscar7.banque.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {
}
