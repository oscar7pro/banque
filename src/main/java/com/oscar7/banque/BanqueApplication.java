package com.oscar7.banque;

import com.oscar7.banque.dao.ClientRepository;
import com.oscar7.banque.dao.CompteRepository;
import com.oscar7.banque.dao.OperationRepository;
import com.oscar7.banque.entities.*;
import com.oscar7.banque.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

/**
 * main
 */
@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    IBanqueMetier banqueMetier;

    public static void main(String[] args) {
        SpringApplication.run(BanqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client1 = clientRepository.save(new Client("Dhalia", "dhalia@pictime.com"));
        Client client2 = clientRepository.save(new Client("Oscar", "oscar@oscaro.com"));
        Client client3 = clientRepository.save(new Client("Davyla", "davyla@yahoo.com"));
        Client client4 = clientRepository.save(new Client("emelyne", "emelyne@gmail.com"));

        Compte compte1 = compteRepository.save(new CompteCourant("client1", new Date(), 90000, client1,6000));
        Compte compte2 = compteRepository.save(new CompteEpargne("client2", new Date(), 1000000, client2, 7.7));
        Compte compte3 = compteRepository.save(new CompteCourant("client3", new Date(), 5000, client3, 1.7));
        Compte compte4 = compteRepository.save(new CompteEpargne("client4", new Date(), 9000, client4, 2.7));

        operationRepository.save(new Versement(new Date(), 9000, compte1));
        operationRepository.save(new Retrait(new Date(), 7000, compte1));

        operationRepository.save(new Versement(new Date(), 1000000, compte2));
        operationRepository.save(new Retrait(new Date(), 70000, compte2));

        operationRepository.save(new Versement(new Date(), 7000, compte3));
        operationRepository.save(new Retrait(new Date(), 2000, compte3));

        operationRepository.save(new Versement(new Date(), 29000, compte4));
        operationRepository.save(new Retrait(new Date(), 70500, compte4));

        banqueMetier.verser("client1", 7700);
        banqueMetier.verser("client2", 77777000);
        banqueMetier.verser("client3", 770000);
        banqueMetier.verser("client4", 7770000);
    }
}
