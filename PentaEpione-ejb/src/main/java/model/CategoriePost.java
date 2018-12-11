package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CategoriePosts database table.
 * 
 */
@Entity
@Table(name="CategoriePosts")
@NamedQuery(name="CategoriePost.findAll", query="SELECT c FROM CategoriePost c")
public class CategoriePost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Description")
	private String description;

	@Column(name="Libelle")
	private String libelle;

	public CategoriePost() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}