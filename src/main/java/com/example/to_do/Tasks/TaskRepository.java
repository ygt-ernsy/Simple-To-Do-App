package com.example.to_do.Tasks;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findTasksByTask(String task);

}
