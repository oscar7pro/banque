package com.oscar7.banque.service;

import com.oscar7.banque.dao.CompteRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BanqueServiceImpl.class, CompteRepository.class,BanqueServiceImpl.class })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BanqueServiceImplUnitTest {
 /*   @Autowired
    CompteRepository compteRepository;

    @InjectMocks
    BanqueServiceImpl banqueService;


    @Test
    public void when_find_by_Id_consulterCompte_should_return_compte() {
        // GIVEN
      *//*  final String codeCompte = "client1";
        Compte compte = new CompteCourant();
        compte.setCodeCompte(codeCompte);
        compte.setDateCreation(new Date());
        compte.setClient(new Client());

        Operation retrait = new Retrait();
        Operation versemement = new Versement();
        List<Operation> operations = new ArrayList<>();
        operations.add(versemement);
        operations.add(retrait);
        compte.setOperations(operations);

        Optional<Compte> unCompte = compteRepository.findById(codeCompte);

        // WHEN
        Compte result = banqueService.consulterCompte(codeCompte);

        // THEN
        Assertions.assertEquals(unCompte, result.getCodeCompte());*//*

    }*/
}
