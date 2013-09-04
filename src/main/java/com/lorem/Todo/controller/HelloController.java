package com.lorem.Todo.controller;

import java.net.Authenticator.RequestorType;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lorem.Todo.model.Item;
import com.lorem.Todo.model.User;
import com.lorem.Todo.service.ItemService;


@Controller
@SessionAttributes({"user_id", "logged_in"})
public class HelloController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/hello")
	public String sayHello(Model model) {
		System.out.println("Controller matched");
		
		model.addAttribute("items", new String[]{"Item #1", "Item #2", "Item #3"});
		
		return "hello";
	}
	
	@RequestMapping(value="/hello/{id}")
	public String sayHelloToUser(
			@PathVariable Integer id, 
			@ModelAttribute(value="logged_in") boolean logged_in, 
			Model model) {
	
		model.addAttribute("username", "UserName#" + id);
		model.addAttribute("user_id", id);
		
		System.out.println(id);
		System.out.println("Logged in: " + logged_in);
		
		
		if (id == 1234) {
			model.addAttribute("logged_in", true);
		} else if (id == 111) {
			model.addAttribute("logged_in", false);
		}
		
		
		
		model.addAttribute("items", new String[]{"Item #1", "Item #2", "Item #3"});
		
		return "hello";
	}
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public String showItems(Model model) {
		model.addAttribute("item", new Item());
		
		model.addAttribute("items", itemService.getAllItems());
		
		return "items/items";
	}
	
	@RequestMapping(value="/items", method=RequestMethod.POST)
	public String addItem(
			@Valid @ModelAttribute("item") Item item,
			BindingResult result) {
		
		if(!result.hasErrors()) {
			System.out.println("Saving item");
			itemService.save(item);
			return "redirect:items.do";
		}
		
		return "items/items";
	}

}
