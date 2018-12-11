package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MessageId")
	private int messageId;

	@Column(name="Content")
	private String content;

	private int receiver;

	private int sender;

	//bi-directional many-to-one association to Chat
	@ManyToOne
	private Chat chat;

	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReceiver() {
		return this.receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getSender() {
		return this.sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public Chat getChat() {
		return this.chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}