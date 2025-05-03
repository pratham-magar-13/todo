package com.jackdaw.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private boolean completed;
//	public int getId() {
//		return id;
//	}
//	public Task() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public boolean isCompleted() {
//		return completed;
//	}
//	public void setCompleted(boolean completed) {
//		this.completed = completed;
//	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
	
}
