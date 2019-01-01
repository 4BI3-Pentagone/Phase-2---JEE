package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Conges
 *
 */
@Entity

public class Conges implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Id
	private int id;
	private Date date_debut;
	private Date date_fin;
	@ManyToOne
	private Agent agent;
	private static final long serialVersionUID = 1L;

	public Conges() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDate_debut() {
		return this.date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}   
	public Date getDate_fin() {
		return this.date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
   
}
