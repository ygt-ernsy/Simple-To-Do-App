package com.example.to_do.Tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public List<Task> getTasks() {
		return taskService.getTasks();
	}

	@PostMapping
	public void registerNewTask(@RequestBody Task task) {
		taskService.addNewTask(task);
	}

	@DeleteMapping(path = "{taskId}")
	public void deleteTask(@PathVariable("taskId") Long taskId) {
		taskService.deleteTask(taskId);

	}

	@PutMapping(path = "{taskId}")
	public void updateTask(@PathVariable("taskId") Long taskId, @RequestParam(required = true) String newTask) {
		taskService.updateTask(taskId, newTask);
	}
}
