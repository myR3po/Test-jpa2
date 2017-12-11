package dev.banque.ihm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.banque.model.Adresse;
import dev.banque.model.AssuranceVie;
import dev.banque.model.Banque;
import dev.banque.model.Client;
import dev.banque.model.Compte;
import dev.banque.model.LivretA;
import dev.banque.model.Virement;

public class AppConsole {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppConsole.class);
	
	public AppConsole() {
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque-jpa");

		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		LOGGER.debug("Creation de la banque...");
		Banque banque = new Banque();
		banque.setNom("theBanque");
		
		
		LOGGER.debug("Ajout banque en base...");
		entityManager.persist(banque);
		
		LOGGER.debug("Creation d'un client...");
		Client client1 = null;
		
		client1 = new Client("Name", "firstname", LocalDate.of(1956, 05, 25));
		client1.setAdresse(new Adresse(78, "pas de nom", 35700, "rennes"));
		client1.setBanque(banque);
		
		LOGGER.debug("Creation d'un compte assurance vie...");
		AssuranceVie assurance = new AssuranceVie();
		assurance.setNumero("44200");
		assurance.setSolde(5000.);
		assurance.setDateFin(LocalDate.of(2050, 6, 6));
		assurance.setTaux(5.2);
		entityManager.persist(assurance);
				
		client1.getComptes().add(assurance);
		
		LOGGER.debug("Ajout du client en base...");
		entityManager.persist(client1);
		
		
		LOGGER.debug("Creation d'un autre client...");
		
		Client client2 = null;
		client2 = new Client("Name2", "firstname2", LocalDate.of(1976, 05, 25));
		client2.setAdresse(new Adresse(65, "pas de nom", 44000, "nantes"));
		client2.setBanque(banque);		
		
		LOGGER.debug("Creation d'un compte livret...");
		LivretA livret = new LivretA();
		livret.setNumero("44100");
		livret.setSolde(1500.);
		livret.setTaux(3.15);
		
		client2.getComptes().add(livret);
		entityManager.persist(client2);
		
		
		LOGGER.debug("Creation d'une Operation...");
		
		Virement virement = new Virement();
		virement.setBeneficiaire("ELLE");
		virement.setDate(LocalDateTime.of(2018, 01, 18, 12,10));
		virement.setMontant(500.);
		virement.setMotif("a sec");
		
		livret.getOperations().add(virement);
//		entityManager.persist(livret);
		
		virement.getComptes().add(livret);
		entityManager.persist(virement);
//		client2.getComptes()

		
		entityTransaction.commit();
		entityManager.close();

		if (factory != null) {
			factory.close();
		}
		LOGGER.debug("Fin...");
	}
}
