package com.example.to_do.Tasks;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

	@Bean
	CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
		return args -> {

			Task task1 = new Task("Do the dishes! ");

			Task task2 = new Task("Do the laundry! ");

			taskRepository.saveAll(List.of(task1, task2));
		};
	}

}
