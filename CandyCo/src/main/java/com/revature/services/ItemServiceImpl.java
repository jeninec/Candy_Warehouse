package com.revature.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Item;
import com.revature.repositories.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepo ir;
	
	@Override
	public Item addItem(Item i) {
		return ir.save(i);
	}

	@Override
	public Item getItem(int id) {
		try {
			return ir.findById(id).get();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Item> getAllItems() {
		return (List<Item>) ir.findAll();
	}

	@Override
	public Item updateItem(Item change) {
		return ir.save(change);
	}

	@Override
	public boolean deleteItem(int id) {
		try { 
			ir.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public Item getItem(String name) {
		try {
			return ir.findByName(name);
		} catch (Exception e) {
			return new Item();
		}
	}
	
	@Override
	public List<Item> getItemByCatagory(String catagory) {
		try {
			return ir.findByCatagory(catagory);
		} catch (Exception e) {
			return null;
		}
	}

}
