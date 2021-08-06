package com.revature.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.revature.models.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {

	List<Item> findByName(String name);


}
