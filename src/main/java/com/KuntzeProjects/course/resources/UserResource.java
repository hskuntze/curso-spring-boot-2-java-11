package com.KuntzeProjects.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KuntzeProjects.course.entities.User;

//Indica que é um recurso web controlado por um controlador rest
@RestController
@RequestMapping(value = "/users") //Dá um nome ao recurso
public class UserResource {
	
	//ResponseEntity é um tipo específico do Spring pra retornar respostas de requisições web
	@GetMapping //Indica que esse método responde ao método 'GET' do HTTP
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "João", "joão@gmail.com", "6198876543", "123");
		return ResponseEntity.ok().body(u);
	}
}
