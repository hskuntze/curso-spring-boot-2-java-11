package com.KuntzeProjects.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course.entities.User;
import com.KuntzeProjects.course.repositories.UserRepository;
import com.KuntzeProjects.course.services.exceptions.DatabaseException;
import com.KuntzeProjects.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //findById retorna o tipo "Optional" existente desde o Java8
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj); //Esta operação retorna um objeto "salvo" (realiza a operação de salvamento)
	}
	
	public void delete(Long id) {
		try {	
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id); //'getOne' permite que o objeto seja monitorado pelo JPA antes de ser modificado definitivamente no banco de dados
			updateData(entity, obj); //Método auxiliar
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
