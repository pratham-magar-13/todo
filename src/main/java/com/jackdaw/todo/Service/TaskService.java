package com.jackdaw.todo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.jackdaw.todo.controller.TaskController;
import com.jackdaw.todo.model.Task;
import com.jackdaw.todo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
	// Constructor for dependency injection
	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository=taskRepository;
	}
	//this is the method that fetches the tasks and returns as a list
	public List<Task> getAllTasks()
	{
		List<Task> tasks=taskRepository.findAll(); //retrieves all tasks from the database
		System.out.println("Fetched Tasks:"+tasks); //debugging line to see if the data is fetched or not
		return tasks;
	}
	//Method to create and save a new task in the database
	public void createTask(String title)
	{
		Task task=new Task();// creates a new task object
		task.setTitle(title);//sets the title of the task
		task.setCompleted(false);//sets the default completed status to false
		taskRepository.save(task);//save the task in to the database
	}
	//method to delete the task by passing the id
	public void deleteTask(int id)
	{
		taskRepository.deleteById(id);
	}
	//method to toggle the completion status of the task by passing the id
		public void toggleTask(int id)
		{
			Task task=taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid task id"));
			task.setCompleted(!task.isCompleted());
			taskRepository.save(task);
			
		}
}
