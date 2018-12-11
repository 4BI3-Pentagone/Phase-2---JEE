package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Debreifs database table.
 * 
 */
@Entity
@Table(name="Debreifs")
@NamedQuery(name="Debreif.findAll", query="SELECT d FROM Debreif d")
public class Debreif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DebreifId")
	private int debreifId;

	@Column(name="Description")
	private String description;

	@Column(name="FinalDisease")
	private String finalDisease;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	private Appointment appointment;

	public Debreif() {
	}

	public int getDebreifId() {
		return this.debreifId;
	}

	public void setDebreifId(int debreifId) {
		this.debreifId = debreifId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFinalDisease() {
		return this.finalDisease;
	}

	public void setFinalDisease(String finalDisease) {
		this.finalDisease = finalDisease;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

}