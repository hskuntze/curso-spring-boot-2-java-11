package com.KuntzeProjects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course.entities.User;
import com.KuntzeProjects.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //findById retorna o tipo "Optional" existente desde o Java8
		return obj.get(); //a função .get do "Optional" retorna o tipo que está definido no Optional, no caso, User
	}
	
	public User insert(User obj) {
		return repository.save(obj); //Esta operação retorna um objeto "salvo" (realiza a operação de salvamento)
	}
}
