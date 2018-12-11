package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the testts database table.
 * 
 */
@Entity
@Table(name="testts")
@NamedQuery(name="Testt.findAll", query="SELECT t FROM Testt t")
public class Testt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testtId;

	public Testt() {
	}

	public int getTesttId() {
		return this.testtId;
	}

	public void setTesttId(int testtId) {
		this.testtId = testtId;
	}

}