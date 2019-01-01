package model;

import java.io.Serializable;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent  implements Serializable {
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String nom;
	private String prenom;
	@NotNull
	@Column(unique=true)
	private String matricule;
	@ManyToOne
	private Site site;
	
	private String contrat;
	private BigDecimal nbreHeure;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "matricule" ,fetch = FetchType.EAGER)
    private Collection<Mission> missionCollection;
	
	
	
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}   
	public Agent(String nom,String prenom,String matricule,Site site,BigDecimal nbreHeure) {
		super();
		this.nom=nom;
		this.prenom=prenom;
		this.matricule=matricule;
		this.site=site;
		this.nbreHeure=nbreHeure;
		
	} 
	
	
	public Agent(int id, String nom, String prenom, String matricule, Site site, String contrat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		this.contrat = contrat;
		
	}
	public Agent(String nom, String prenom, String matricule, Site site, String contrat) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		this.contrat = contrat;
		
	}
	public Agent(String nom, String prenom, String matricule, Site site) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		
		
	}
	
	
	public Agent(int id, String nom, String prenom, String matricule, Site site, String contrat, BigDecimal nbreHeure) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		this.contrat = contrat;
		this.nbreHeure = nbreHeure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public String getContrat() {
		return contrat;
	}
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}
	public BigDecimal getNbreHeure() {
		return nbreHeure;
	}
	public void setNbreHeure(BigDecimal nbreHeure) {
		this.nbreHeure = nbreHeure;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Agent [matricule=" + matricule + "]";
	}
	public Collection<Mission> getMissionCollection() {
		return missionCollection;
	}
	public void setMissionCollection(Collection<Mission> missionCollection) {
		this.missionCollection = missionCollection;
	}
	
	
	
}
