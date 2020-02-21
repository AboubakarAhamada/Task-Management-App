/**
 * 
 */
package com.aboubakar.TaskManangementSpringBoot;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Aboubakar
 *
 */

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@Size(min=10,message="La description d'une tache doit avoir au moins 10 caractères")
	private String description;
	private String priority; // A=Urgent ; B= Important ; C = Facultative
	private Date date;
	
	public Task() {
		super();
	}
	
	public Task(String name, String description, String priority, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.date = date;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
