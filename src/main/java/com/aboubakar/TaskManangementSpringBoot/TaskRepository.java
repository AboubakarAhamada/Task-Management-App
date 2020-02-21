/**
 * 
 */
package com.aboubakar.TaskManangementSpringBoot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aboubakar
 * @param <T>
 *
 */
public interface TaskRepository extends JpaRepository<Task,Long> {
	
	public List<Task> findByPriority(String priority);
}
