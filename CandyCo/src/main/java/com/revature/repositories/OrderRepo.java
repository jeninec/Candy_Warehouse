package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.revature.models.Order;


@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {

}
