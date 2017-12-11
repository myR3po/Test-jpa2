package dev.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	@Id
	@Column(name = "compteId", nullable = false)
	private String numero;

	@Column(nullable = false)
	private Double solde;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "clients_comptes", 
			joinColumns = {@JoinColumn(name = "compteId", nullable = false) }, 
			inverseJoinColumns = {@JoinColumn(name = "clientId", nullable = false) })
	private Set<Client> clients = new HashSet<>(0);

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "comptes")
	private Set<Operation> operations = new HashSet<>(0);

	public Compte() {
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}
