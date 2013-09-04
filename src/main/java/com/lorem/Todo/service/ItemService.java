package com.lorem.Todo.service;

import java.util.List;

import com.lorem.Todo.model.Item;

public interface ItemService {
	public List<Item> getAllItems();
	
	public Item save(Item item);
}
