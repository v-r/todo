package com.lorem.Todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Integer priority = 0;
	
	@NotNull
	@Size(min=3)
	private String description;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Item() {}
	
	public Item(String description) {
		this.description = description;
	}
	
	public Item(String description, Integer priority) {
		this.priority 	 = priority;
		this.description = description;
	}
	
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
