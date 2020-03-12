package be.pxl.ja2.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String text;

	public Message() {
		// wordt in principe enkel door JPA gebruikt, niet door productiecode
	}

	public Message(String text) {
		this.text = text;
	}

	public Message(long messageId, String text) {
		this.id = messageId;
		this.text = text;
	}

	public void setId(long Id) {this.id = id;}

	public long getId() {
		return id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
