package com.sochacki.michal.notes.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Audited
@Table(name="note")
public class Note {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@NotNull
	@Column(name="title")
	private String title;

	@NotNull
	@Column(name="content")
	private String content;

	/*
	@Column(name="created")
	@CreationTimestamp
	private Timestamp created;

	@Column(name="modified")
	@UpdateTimestamp
	private Timestamp modified;
	*/

	@Column(name="created")
	private LocalDateTime created;

	@Column(name = "modified")
	private LocalDateTime modified;

	@Column(name="version")
	private int version;

	// define constructors
	public Note() {

	}

	public Note(String title, String content) {
		this.title = title;
		this.content = content;
	}


	// Define actions happen before creating entity
	@PrePersist
	public void prePersist() {
		this.created = LocalDateTime.now();
		this.version ++;
	}

	// Define actions happen before updating entity
	@PreUpdate
	public void preUpdate() {
		this.modified = LocalDateTime.now();
		this.version ++;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.version ++;
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	// define toString

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", created=" + created +
				", modified=" + modified +
				'}';
	}
}