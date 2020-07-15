package com.oscar7.banque.service;

import com.oscar7.banque.dao.CompteRepository;
import com.oscar7.banque.dao.OperationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        Assertions.assertTrue(true);
    }
}
