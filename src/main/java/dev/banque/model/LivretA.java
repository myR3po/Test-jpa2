package dev.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {

	@Column(nullable = false)
	private Double taux;
	
	public LivretA() {
	}

	/**
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
