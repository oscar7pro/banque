package com.oscar7.banque;

import com.oscar7.banque.dao.ClientRepository;
import com.oscar7.banque.dao.CompteRepository;
import com.oscar7.banque.dao.OperationRepository;
import com.oscar7.banque.entities.*;
import com.oscar7.banque.service.IBanqueService;
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
    IBanqueService banqueMetier;

    public static void main(String[] args) {
        SpringApplication.run(BanqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client1 = clientRepository.save(new Client("Dhalia", "dhalia@pictime.com"));
        Client client2 = clientRepository.save(new Client("Oscar", "oscar@oscaro.com"));
        Client client3 = clientRepository.save(new Client("Davyla", "davyla@yahoo.com"));
        Client client4 = clientRepository.save(new Client("emelyne", "emelyne@gmail.com"));
        Client client5 = clientRepository.save(new Client("Dimitri", "dimitar@gmail.com"));
        Client client7 = clientRepository.save(new Client("Oscarine", "oscarine.s@gmail.com"));

        Compte compte1 = compteRepository.save(new CompteCourant("client1", new Date(), 90000, client1,6000));
        Compte compte2 = compteRepository.save(new CompteEpargne("client2", new Date(), 1000000, client2, 7.7));
        Compte compte3 = compteRepository.save(new CompteCourant("client3", new Date(), 5000, client3, 1.7));
        Compte compte4 = compteRepository.save(new CompteEpargne("client4", new Date(), 9000, client4, 2.7));
        Compte compte5 = compteRepository.save(new CompteEpargne("client5", new Date(), 9000, client5, 2.7));
        Compte compte7 = compteRepository.save(new CompteEpargne("client7", new Date(), 9000, client7, 1.7));

        operationRepository.save(new Versement(new Date(), 9000, compte1));
        operationRepository.save(new Retrait(new Date(), 7000, compte1));

        operationRepository.save(new Versement(new Date(), 100000, compte2));
        operationRepository.save(new Retrait(new Date(), 10000, compte2));

        operationRepository.save(new Versement(new Date(), 7000, compte3));
        operationRepository.save(new Retrait(new Date(), 2000, compte3));

        operationRepository.save(new Versement(new Date(), 9000, compte4));
        operationRepository.save(new Retrait(new Date(), 7050, compte4));

        operationRepository.save(new Versement(new Date(), 2000, compte5));
        operationRepository.save(new Retrait(new Date(), 1500, compte5));

        operationRepository.save(new Versement(new Date(), 50000, compte7));
        operationRepository.save(new Retrait(new Date(), 2500, compte7));

        banqueMetier.verser("client1", 7000);
        banqueMetier.verser("client2", 100000);
        banqueMetier.verser("client3", 7100);
        banqueMetier.verser("client4", 1000);
        banqueMetier.verser("client5", 7770);
        banqueMetier.verser("client7", 20000);
    }
}
