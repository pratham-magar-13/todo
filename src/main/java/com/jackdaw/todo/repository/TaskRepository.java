package com.jackdaw.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jackdaw.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
