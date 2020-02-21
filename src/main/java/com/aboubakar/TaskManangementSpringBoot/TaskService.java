/**
 * 
 */
package com.aboubakar.TaskManangementSpringBoot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aboubakar
 *
 */

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository repository;
	

	@Override
	public Optional<Task> getTaskById(long id) {
		
		return repository.findById(id);
	}

	
	
	@Override
	public List<Task> getTaskByPriority(String priority) {
		
		return repository.findByPriority(priority);
	}

	@Override
	public void addTask(String name, String description, String priority, Date date) {
		
		repository.save(new Task(name,description,priority,date));
	}

	@Override
	public void saveTask(Task task) {
		
		repository.save(task);
	}

	@Override
	public void updateTask(Task task) {
		
		repository.save(task);
	}

	@Override
	public void deleteTask(long id) {
		
		Optional<Task> task = repository.findById(id);
		
		if(task.isPresent()) {
			repository.delete(task.get());
		}
		
	}

	@Override
	public List<Task> getAllTasks() {
		
		return repository.findAll();
	}

}
