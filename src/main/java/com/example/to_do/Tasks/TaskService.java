package com.example.to_do.Tasks;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

	private TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;

	}

	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	public void addNewTask(Task task) {
		Optional<Task> taskOptional = taskRepository.findTasksByTask(task.getTask());

		if (taskOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This task already exists");
		}

		taskRepository.save(task);
		System.out.println(task);
	}

	public void deleteTask(Long id) {
		boolean isPresent = taskRepository.existsById(id);

		if (!isPresent)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"This task with the id " + id + " does not exist.");

		taskRepository.deleteById(id);
	}

	@Transactional
	public void updateTask(Long id, String newTask) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"A task with the id " + id + " does not exist"));
		if (newTask != null) {
			task.setTask(newTask);
		}

		task.setTask(newTask); // assuming you have a setTask method
	}
}
