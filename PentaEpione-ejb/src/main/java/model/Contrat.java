package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contrat
 *
 */
@Entity

public class Contrat implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private double nbr_heure;
	private static final long serialVersionUID = 1L;

	public Contrat() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public double getNbr_heure() {
		return this.nbr_heure;
	}

	public void setNbr_heure(double nbr_heure) {
		this.nbr_heure = nbr_heure;
	}
   
}
