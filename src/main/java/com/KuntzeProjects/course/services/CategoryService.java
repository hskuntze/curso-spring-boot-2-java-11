package com.KuntzeProjects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course.entities.Category;
import com.KuntzeProjects.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); //findById retorna o tipo "Optional" existente desde o Java8
		return obj.get(); //a função .get do "Optional" retorna o tipo que está definido no Optional, no caso, Category
	}
}
