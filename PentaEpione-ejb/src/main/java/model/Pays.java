package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pays {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Id
	private int id;
	private String nom;
	public Pays() {
		super();
	}
	public Pays(String nom) {
		super();
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}

}
