package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SubComments database table.
 * 
 */
@Entity
@Table(name="SubComments")
@NamedQuery(name="SubComment.findAll", query="SELECT s FROM SubComment s")
public class SubComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SubComID")
	private int subComID;

	@Column(name="CommentedDate")
	private Timestamp commentedDate;

	@Column(name="CommentMsg")
	private String commentMsg;

	@Column(name="UserID")
	private int userID;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="ComID")
	private Comment comment;

	public SubComment() {
	}

	public int getSubComID() {
		return this.subComID;
	}

	public void setSubComID(int subComID) {
		this.subComID = subComID;
	}

	public Timestamp getCommentedDate() {
		return this.commentedDate;
	}

	public void setCommentedDate(Timestamp commentedDate) {
		this.commentedDate = commentedDate;
	}

	public String getCommentMsg() {
		return this.commentMsg;
	}

	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}