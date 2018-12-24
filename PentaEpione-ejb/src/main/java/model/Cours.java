package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Courses database table.
 * 
 */
@Entity
@Table(name="Courses")
@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CourseId")
	private int courseId;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="cours")
	private List<AspNetUser> aspNetUsers;

	//bi-directional one-to-one association to AspNetUser
	@OneToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="CourseId", referencedColumnName="course_CourseId")
	private AspNetUser aspNetUser;

	public Cours() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setCours(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setCours(null);

		return aspNetUser;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	@Override
	public String toString() {
		return "Cours [courseId=" + courseId + ", aspNetUsers=" + aspNetUsers + ", aspNetUser=" + aspNetUser + "]";
	}

}