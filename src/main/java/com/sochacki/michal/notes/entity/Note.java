package com.sochacki.michal.notes.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
//@Audited
@Table(name="note")
public class Note {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name="title")
	private String title;

	@Column(name="content")
	private String content;

	@Column(name="created")
	@CreationTimestamp
	private Timestamp created;

	@Column(name="modified")
	@UpdateTimestamp

	private Timestamp modified;

	// define constructors

	public Note() {

	}

	public Note(String title, String content) {
		this.title = title;
		this.content = content;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
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











