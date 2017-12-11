package dev.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="banque")
public class Banque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer banqueId;
	
	@Column(nullable = false)
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients = new HashSet<>(0);
	
	public Banque() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the banque Id
	 */
	public Integer getBanqueId() {
		return banqueId;
	}


	/**
	 * @param banqueId the banqueId to set
	 */
	public void setBanqueId(Integer banqueId) {
		this.banqueId = banqueId;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	

}
