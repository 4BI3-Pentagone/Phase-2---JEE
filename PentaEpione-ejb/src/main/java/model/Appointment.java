package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Appointments database table.
 * 
 */
@Entity
@Table(name="Appointments")
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", disease=" + disease + ", state="
				+ state + ", aspNetUser1=" + aspNetUser1 + ", aspNetUser2=" + aspNetUser2 + ", debreifs=" + debreifs
				+ "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppointmentId")
	private int appointmentId;
	@Column(name="Rate")
	private int  rate;
	@Column(name="Date")
	private Date  date;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Column(name="Disease")
	private String disease;

	private int state;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="patient_Id")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to Debreif
	@OneToMany(mappedBy="appointment")
	private List<Debreif> debreifs;

	public Appointment() {
	}
 
	public Appointment(int appointmentId, Date date, String disease, int state) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.disease = disease;
		this.state = state;
	}
	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public List<Debreif> getDebreifs() {
		return this.debreifs;
	}

	public void setDebreifs(List<Debreif> debreifs) {
		this.debreifs = debreifs;
	}

	public Debreif addDebreif(Debreif debreif) {
		getDebreifs().add(debreif);
		debreif.setAppointment(this);

		return debreif;
	}

	public Debreif removeDebreif(Debreif debreif) {
		getDebreifs().remove(debreif);
		debreif.setAppointment(null);

		return debreif;
	}

}