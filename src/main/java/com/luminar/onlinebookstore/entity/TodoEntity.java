package com.luminar.onlinebookstore.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Nonnull
	private Long id;

	@Column(nullable = false)
	@Nonnull
	private String title;

	@Column(length = 500)
	private String description;

	@Column(nullable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	@Column
	@Nonnull
	private String status;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	public TodoEntity() {
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	// Automatically set the createdDate before saving to the database
	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}

	// Automatically set the updateDate before updating the entity
	@PreUpdate
	protected void onUpdate() {
		updateDate = new Date();
	}
}
