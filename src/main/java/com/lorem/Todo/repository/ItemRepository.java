package com.lorem.Todo.repository;

import java.util.List;

import com.lorem.Todo.model.Item;

public interface ItemRepository {
	
	public abstract List<Item> findAll();

	public abstract List<Item> findByPriority(Integer priority);

	public abstract Item getFirst();
	
	public abstract Item save(Item item);

}