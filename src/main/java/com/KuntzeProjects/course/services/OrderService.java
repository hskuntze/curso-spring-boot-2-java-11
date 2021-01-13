package com.KuntzeProjects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course.entities.Order;
import com.KuntzeProjects.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id); //findById retorna o tipo "Optional" existente desde o Java8
		return obj.get(); //a função .get do "Optional" retorna o tipo que está definido no Optional, no caso, Order
	}
}
