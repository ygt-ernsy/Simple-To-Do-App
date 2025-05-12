package com.example.to_do.Tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
// @Table
public class Task {

	@Id
	@SequenceGenerator(name = "task_sequeace", sequenceName = "task_sequeace", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequeace")
	private long id;
	private String task;

	public Task() {

	}

	public Task(long id, String task) {
		this.id = id;
		this.task = task;
	}

	public Task(String task) {
		this.task = task;

	}

	public String getTask() {
		return task;
	}

	public long getId() {
		return id;
	}

	public String toString() {
		return "Your task is: " + task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setId(long id) {
		this.id = id;
	}
}
