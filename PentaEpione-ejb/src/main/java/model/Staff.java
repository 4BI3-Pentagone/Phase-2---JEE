package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Staff {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idStaff;
	private String nom;
	private String prenom;
	private String matricule;
	private String typeContrat;
	private int nbreHeure;

	
	public Staff() {
		super();
		
	}

	

	public Staff(int idStaff, String nom, String prenom, String matricule, String typeContrat, int nbreHeure) {
		super();
		this.idStaff = idStaff;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.typeContrat = typeContrat;
		this.nbreHeure = nbreHeure;
	}



	public int getIdStaff() {
		return idStaff;
	}


	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public int getNbreHeure() {
		return nbreHeure;
	}


	public void setNbreHeure(int nbreHeure) {
		this.nbreHeure = nbreHeure;
	}
	
	
	
	
	
	
	
	
	
}
