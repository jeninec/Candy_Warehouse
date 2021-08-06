package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Item;
import com.revature.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService is;
	
	@GetMapping(value = "/items", produces = "application/json")
	public List<Item> getAllItems(){
		return is.getAllItems();
	}
	
	@GetMapping("items/{id}")
	public Item getItem(@PathVariable("id") String id) {
		return is.getItem(Integer.parseInt(id));
		
	}
	
	@GetMapping("items/search")
	public List<Item> getItemByName(@RequestParam("name") String name){
		return is.getItem(name);
	}
	
	@PostMapping(value = "/items", consumes = "application/json", produces = "application/json")
	public Item addItem(@RequestBody Item i) {
		return is.addItem(i);
	}
	
	@PutMapping(value = "/items/{id}", consumes = "application/json", produces = "application/json")
	public Item updateItem(@PathVariable int id, @RequestBody Item change) {
		change.setId(id);
		return is.updateItem(change);
	}
	
	@DeleteMapping("/items/{id}")
	public boolean deleteItem(@PathVariable int id) {
		return is.deleteItem(id);
	}
}
