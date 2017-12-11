package dev.banque.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer operationId;
	
	@Column(nullable = false)
	private LocalDateTime date;
	
	@Column(nullable = false)
	private Double montant;
	
	@Column(nullable = false)
	private String motif;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "comptes_operations", 
				joinColumns = {@JoinColumn(name = "operationId", nullable = false) }, 
				inverseJoinColumns = {@JoinColumn(name = "compteId", nullable = false) })
	private Set<Compte> comptes = new HashSet<>(0);
	
	public Operation() {
	}

	
	/**
	 * @return the operation Id
	 */
	public Integer getOperationId() {
		return operationId;
	}


	/**
	 * @param operationId the operation Id to set
	 */
	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}


	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}


	/**
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}


	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
