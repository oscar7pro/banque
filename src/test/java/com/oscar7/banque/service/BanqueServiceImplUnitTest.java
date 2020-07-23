package com.oscar7.banque.service;

import com.oscar7.banque.dao.CompteRepository;
import com.oscar7.banque.dao.OperationRepository;
import com.oscar7.banque.entities.*;
import com.oscar7.banque.service.impl.BanqueServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class BanqueServiceImplUnitTest {
    @Mock
    private CompteRepository compteRepository;

    @Mock
    private OperationRepository operationRepository;

    @InjectMocks
    private BanqueServiceImpl banqueService;

    @Test
    public void when_find_by_Id_consulterCompte_should_return_compte() {
        // GIVEN
       // String id = "compte1";
        Compte compte = Mockito.mock(Compte.class);
        String codeCompte = compte.getCodeCompte();
        Client compteClient = Mockito.mock(Client.class);

        // WHEN
        //Mockito.doReturn(createTestEntity()).when(compteRepository.findById(codeCompte));
      Mockito.when(compteRepository.findById(codeCompte)).thenReturn(java.util.Optional.of(createTestEntity()));
        // THEN
        Compte result = banqueService.consulterCompte("client1");
        Assertions.assertEquals("client1",result.getCodeCompte());

    }

    private Compte createTestEntity() {
        Operation retrait = new Retrait();
        Operation versement = new Versement();
        Collection<Operation> operationCollection = new ArrayList<>();
        operationCollection.add(retrait);
        operationCollection.add(versement);
        Compte compteCourant = new CompteCourant();
        Client clients7 = new Client();
        String codeCompte = clients7.toString();
        compteCourant.setCodeCompte(codeCompte);
        compteCourant.setSolde(100000);
        compteCourant.setDateCreation(new Date());
        compteCourant.setClient(clients7);
        compteCourant.setOperations(operationCollection);
        return compteCourant;
    }
}
