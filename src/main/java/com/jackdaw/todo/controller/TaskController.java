package com.jackdaw.todo.controller;

import java.util.List;
import com.jackdaw.todo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jackdaw.todo.Service.TaskService;
import com.jackdaw.todo.model.Task;

@Controller
@RequestMapping
public class TaskController {

    private final TaskService taskService;
 // Constructor for dependency injection
	public TaskController(TaskService taskService, TaskRepository taskRepository)
	{
		this.taskService=taskService;// Injects the TaskService instance
	}
	@GetMapping
	public String getTasks(Model model)
	{
		
		//object of taskservice calls function getalltasks
		List<Task> tasks=taskService.getAllTasks();
		// Adds the retrieved tasks to the model, making them accessible in the view
		model.addAttribute("tasks",tasks);
		return "tasks";
	}
	@PostMapping
	public String createTasks(@RequestParam String title)
	{
		 // The 'title' parameter is received from the form input (name="title" in HTML)
		//this title passed as an argument accepts the value from the page(input...name=title these name should be same)
		taskService.createTask(title);
		 // Calls the service layer to create a new task with the given title
		return "redirect:/";
		// Redirects the user back to the homepage after task creation
	}
	@GetMapping("/{id}/delete")//it deletes the task with the mentioned id
	public String deleteTask(@PathVariable int id)
	{
		//path variable tells to look into the ("/{id}/delete") so the data type should match 
		taskService.deleteTask(id);
		return "redirect:/";
	}
	@GetMapping("/{id}/toggle")//it updates the completed status of the task
	public String toggleTask(@PathVariable int id)
	{
		//path variable tells to look into the ("/{id}/delete") so the data type should match 
		taskService.toggleTask(id);
		return "redirect:/";
	}
	
	
	
	
}
