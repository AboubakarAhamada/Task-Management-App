/**
 * 
 */
package com.aboubakar.TaskManangementSpringBoot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Aboubakar
 *
 */
public interface ITaskService {

	Optional<Task> getTaskById(long id);
	
	List<Task> getAllTasks();
	
	List<Task> getTaskByPriority(String priority);
	
	void addTask(String name, String description, String priority, Date date); // create new task
	
	void saveTask(Task task);
	
	void updateTask(Task task);
	
	void deleteTask(long id);
	
	
	
}
