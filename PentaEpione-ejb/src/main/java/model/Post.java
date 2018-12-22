package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Posts database table.
 * 
 */
@Entity
@Table(name="Posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PostID")
	private String postID;
	
    @ManyToOne
    @JoinColumn(name="categoriePost_Id")
	private CategoriePost categoriePost_Id;

	@Column(name="Message")
	private String message;

	@Column(name="PostedDate")
	private Timestamp postedDate;

	@Column(name="Titre")
	private String titre;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="User_Id", referencedColumnName="Id")
	private AspNetUser aspNetUser;

	public Post() {
	}

	public String getPostID() {
		return this.postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getPostedDate() {
		return this.postedDate;
	}

	public void setPostedDate(Timestamp postedDate) {
		this.postedDate = postedDate;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setPost(null);

		return comment;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public CategoriePost getCategoriePost_Id() {
		return categoriePost_Id;
	}

	public void setCategoriePost_Id(CategoriePost categoriePost_Id) {
		this.categoriePost_Id = categoriePost_Id;
	}

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", categoriePost_Id=" + categoriePost_Id + ", message=" + message
				+ ", postedDate=" + postedDate + ", titre=" + titre + ", comments=" + comments + ", aspNetUser="
				+ aspNetUser + "]";
	}

}