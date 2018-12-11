package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Steps database table.
 * 
 */
@Entity
@Table(name="Steps")
@NamedQuery(name="Step.findAll", query="SELECT s FROM Step s")
public class Step implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StepId")
	private int stepId;

	private int course_CourseId;

	private int state;

	private String treatment;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	@JoinColumn(name="visit_AppointmentId")
	private Appointment appointment;

	public Step() {
	}

	public int getStepId() {
		return this.stepId;
	}

	public void setStepId(int stepId) {
		this.stepId = stepId;
	}

	public int getCourse_CourseId() {
		return this.course_CourseId;
	}

	public void setCourse_CourseId(int course_CourseId) {
		this.course_CourseId = course_CourseId;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Step [stepId=" + stepId + ", course_CourseId=" + course_CourseId + ", state=" + state + ", treatment="
				+ treatment + ", appointment=" + appointment + "]";
	}
	

}