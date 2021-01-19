package com.KuntzeProjects.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KuntzeProjects.course.entities.Product;
import com.KuntzeProjects.course.services.ProductService;

//Indica que é um recurso web controlado por um controlador rest
@RestController
@RequestMapping(value = "/products") //Dá um nome ao recurso
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	//ResponseEntity é um tipo específico do Spring pra retornar respostas de requisições web
	@GetMapping //Indica que esse método responde ao método 'GET' do HTTP
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //indica que a requisição 'GET' aceitará um determinado {id} dentro da URL
	public ResponseEntity<Product> findById(@PathVariable Long id){ //para que utilizemos o {id}, primeiro o Spring deve reconhecê-lo como tal, para isso, utilizando a anotação "PathVariable"
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
