package com.oscar7.banque.service;

import com.oscar7.banque.dao.CompteRepository;
import com.oscar7.banque.dao.OperationRepository;
import com.oscar7.banque.entities.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BanqueServiceImpl implements IBanqueService {
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    OperationRepository operationRepository;

    @Override
    public Compte consulterCompte(String codeCompte) {
        return compteRepository.findById(codeCompte)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    @Override
    public void verser(String codeCompte, double montant) {
        Compte compte = consulterCompte(codeCompte);
        Versement versement = new Versement(new Date(), montant, compte);
        operationRepository.save(versement);
        compte.setSolde(compte.getSolde() + montant);
        compteRepository.save(compte);
    }

    @Override
    public void retirer(String codeCompte, double montant) {
        Compte compte = consulterCompte(codeCompte);
        double facilitesCaisse = 0;
        if (compte instanceof CompteCourant) {
            facilitesCaisse = ((CompteCourant) compte).getDecouvert();
        }
        if (compte.getSolde() < montant) {
            throw new RuntimeException("Solde insufisant");
        }
        Retrait retrait = new Retrait(new Date(), montant, compte);
        operationRepository.save(retrait);
        compte.setSolde(compte.getSolde() - montant);
        compteRepository.save(compte);

    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, double montant) {
        if(codeCompte1.equals(codeCompte2)) {
            throw new RuntimeException("Impossibilité d'éffectuer le virement sur le même compte");
        }
        retirer(codeCompte1, montant);
        verser(codeCompte2, montant);
    }

    @Override
    public Page<Operation> listOperation(String codeCompte, int page, int size) {
        return operationRepository.listOperation(codeCompte, PageRequest.of(page, size));
    }

}
