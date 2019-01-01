package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity

public class Site implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Id
	private int id;
	private String nom;
	@ManyToOne
	private Ville ville;
	
	private static final long serialVersionUID = 1L;

	public Site() {
		super();
	}  
	public Site(String nom,Ville ville) {
		super();
		this.nom=nom;
		this.ville=ville;
		
	} 
	


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}






	public Ville getVille() {
		return ville;
	}



	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	} 
   
}
