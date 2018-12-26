package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Comments database table.
 * 
 */
@Entity
@Table(name="Comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="ComID")
	private int comID;

@Column(name="CommentedDate")
	private Timestamp commentedDate;

	@Column(name="CommentMsg")
	private String commentMsg;

	@Column(name="User_Id")
	private String user_Id;

@Column(name="UserID")
private int userID;

	//bi-directional many-to-one association to Post
@ManyToOne
	@JoinColumn(name="PostID")
	private Post post;

	public Comment() {
	}

	public int getComID() {
		return comID;
	}

	public void setComID(int comID) {
		this.comID = comID;
	}

	public Timestamp getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Timestamp commentedDate) {
		this.commentedDate = commentedDate;
	}

	public String getCommentMsg() {
		return commentMsg;
	}

	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}

//	public int getComID() {
//		return this.comID;
//	}

//	public void setComID(int comID) {
//		this.comID = comID;
//	}

//	public Timestamp getCommentedDate() {
//		return this.commentedDate;
//	}

//	public void setCommentedDate(Timestamp commentedDate) {
//		this.commentedDate = commentedDate;
//	}

//	public String getCommentMsg() {
//		return this.commentMsg;
//	}

//	public void setCommentMsg(String commentMsg) {
//		this.commentMsg = commentMsg;
//	}

//	public String getUser_Id() {
//		return this.user_Id;
//	}

//	public void setUser_Id(String user_Id) {
//		this.user_Id = user_Id;
//	}

//	public int getUserID() {
//		return this.userID;
//	}

//	public void setUserID(int userID) {
//		this.userID = userID;
//	}

//	public Post getPost() {
//		return this.post;
//	}

//	public void setPost(Post post) {
//		this.post = post;
//	}

//}