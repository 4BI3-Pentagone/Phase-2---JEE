package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Rates database table.
 * 
 */
@Entity
@Table(name="Rates")
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RateId")
	private int rateId;

	@Column(name="Note")
	private float note;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	private Appointment appointment;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="patient_Id")
	private AspNetUser aspNetUser;

	public Rate() {
	}

	public int getRateId() {
		return this.rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public float getNote() {
		return this.note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Rate(float note ) {
		super();
		this.note = note; 
	}

	
}