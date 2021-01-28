package com.KuntzeProjects.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.KuntzeProjects.course.entities.User;
import com.KuntzeProjects.course.services.UserService;

//Indica que é um recurso web controlado por um controlador rest
@RestController
@RequestMapping(value = "/users") //Dá um nome ao recurso
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//MÉTODOS GET: Para retornar dados do B.D.
	
	//ResponseEntity é um tipo específico do Spring pra retornar respostas de requisições web
	@GetMapping //Indica que esse método responde ao método 'GET' do HTTP
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //indica que a requisição 'GET' aceitará um determinado {id} dentro da URL
	public ResponseEntity<User> findById(@PathVariable Long id){ //para que utilizemos o {id}, primeiro o Spring deve reconhecê-lo como tal, para isso, utilizando a anotação "PathVariable"
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//MÉTODOS POST: Para inserção de dados no B.D.
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
