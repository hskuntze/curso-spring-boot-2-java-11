package com.KuntzeProjects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course.entities.Product;
import com.KuntzeProjects.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); //findById retorna o tipo "Optional" existente desde o Java8
		return obj.get(); //a função .get do "Optional" retorna o tipo que está definido no Optional, no caso, Product
	}
}
