package com.revature.services;

import java.util.List;

import com.revature.models.Item;

public interface ItemService {

	public Item addItem(Item i);
	
	public Item getItem(int id);
	
	public List<Item> getAllItems();
	
	public Item updateItem(Item change);
	
	public boolean deleteItem(int id);

	public Item getItem(String name);
	
	public List<Item> getItemByCatagory(String catagory);
}
