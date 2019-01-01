package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ville {
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Id
	private int id;
	@ManyToOne
	private Pays pays;
	private String nom;
	public Ville () {
		super();
	}
	public Ville(String nom,Pays pays) {
		this.nom=nom;
		this.pays=pays;
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	

}