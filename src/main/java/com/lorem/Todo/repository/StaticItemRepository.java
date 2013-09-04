package com.lorem.Todo.repository;

import java.util.ArrayList;
import java.util.List;
import com.lorem.Todo.model.Item;


public class StaticItemRepository implements ItemRepository {
	private static final List<Item> items = new ArrayList<Item>();
	
	static {
		items.add(new Item("First item"));
		items.add(new Item("Second item", 2));
		items.add(new Item("Optional Item", -1));
		items.add(new Item("Total unnecessary Item", -10));
		
		System.out.println("Static block executes");
	}
	
	/* (non-Javadoc)
	 * @see com.lorem.Todo.repository.ItemRepository#findAll()
	 */
	public List<Item> findAll() {
		
		return items;
	}
	
	/* (non-Javadoc)
	 * @see com.lorem.Todo.repository.ItemRepository#findByPriority(java.lang.Integer)
	 */
	public List<Item> findByPriority(Integer priority) {
		final List<Item> result = new ArrayList<Item>();
		
		for(Item item : items) {
			if (item.getPriority() == priority) {
				result.add(item);
			}
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.lorem.Todo.repository.ItemRepository#getFirst()
	 */
	public Item getFirst() {
		return items.get(0);
	}

	public void addItem(Item item) {
		System.out.println("some item added");
		items.add(item);
	}
	
	public Item save(Item item) {
		items.add(item);
		return item;
	}
}
