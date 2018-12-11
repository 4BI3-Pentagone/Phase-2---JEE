package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="categoriePost")
	private List<Post> posts;

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

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setCategoriePost(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setCategoriePost(null);

		return post;
	}

}