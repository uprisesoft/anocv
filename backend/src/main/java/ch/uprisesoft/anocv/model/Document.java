package ch.uprisesoft.anocv.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String name = "";
	private String original = "";
	private String processed = "";

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Document() {
	}


	public Document(String name, String original, String processed, User user) {
		this.name = name;
		this.original = original;
		this.processed = processed;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public @NotNull String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Document{" +
				"id=" + id +
				", name='" + name + '\'' +
				", original='" + original + '\'' +
				", processed='" + processed + '\'' +
				", user=" + user +
				'}';
	}
}
