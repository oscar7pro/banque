package com.oscar7.banque.metier;

import com.oscar7.banque.entities.Compte;
import com.oscar7.banque.entities.Operation;
import org.springframework.data.domain.Page;


public interface IBanqueMetier {
    public Compte consulterCompte(String codeCompte);
    public void verser(String codeCompte, double montant);
    public void retirer(String codeCompte, double montant);
    public void virement(String codeCompte1, String codeCompte2,double montant);
    public Page<Operation> listOperation(String codeCompte, int page, int size);
}
