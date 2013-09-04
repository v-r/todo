package com.lorem.Todo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lorem.Todo.model.Item;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List<Item> findAll() {
		return null;
	}

	public List<Item> findByPriority(Integer priority) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item getFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Item save(Item item) {
		em.persist(item);
		
		em.flush();
		
		return item;
	}

}
