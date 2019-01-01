package model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flux
 *
 */
@Entity

public class Flux implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double charge_horaire;
	private String intitule;
	private static final long serialVersionUID = 1L;

	public Flux() {
		super();
	}   
	public Flux(int id,double charge_horaire,String intitule) {
		super();
		this.id=id;
		this.charge_horaire = charge_horaire;
		this.setIntitule(intitule);
	}
	public Flux(double charge_horaire,String intitule) {
		super();
		this.charge_horaire = charge_horaire;
		this.setIntitule(intitule);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getCharge_horaire() {
		return this.charge_horaire;
	}

	public void setCharge_horaire(double charge_horaire) {
		this.charge_horaire = charge_horaire;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
   
}
