package com.lorem.Todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lorem.Todo.model.Item;
import com.lorem.Todo.repository.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	@Transactional
	public Item save(Item item) {
		return itemRepository.save(item);
	}
}
