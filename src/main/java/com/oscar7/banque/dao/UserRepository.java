package com.oscar7.banque.dao;

import com.oscar7.banque.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
