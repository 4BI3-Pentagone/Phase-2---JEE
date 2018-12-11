package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Repports database table.
 * 
 */
@Entity
@Table(name="Repports")
@NamedQuery(name="Repport.findAll", query="SELECT r FROM Repport r")
public class Repport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RepportId")
	private int repportId;

	@Column(name="ReppotName")
	private String reppotName;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="course_CourseId")
	private Cours cours;

	public Repport() {
	}

	public int getRepportId() {
		return this.repportId;
	}

	public void setRepportId(int repportId) {
		this.repportId = repportId;
	}

	public String getReppotName() {
		return this.reppotName;
	}

	public void setReppotName(String reppotName) {
		this.reppotName = reppotName;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

}