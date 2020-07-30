package com.aurock.CursoJava.resources;

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

import com.aurock.CursoJava.entities.User;
import com.aurock.CursoJava.services.UserService;

@RestController //parametro do fremework que define que a class é um rest de algun recurso, no caso User
@RequestMapping(value ="/users")//parametro que define o nome usado para requisitar o recurso, informando o caminho do recurso	
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping //parametro que define o metodo que será executado quando houver a requisição do tipo GET definida em RequestMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User objUser = service.findById(id);
		return ResponseEntity.ok().body(objUser);
	}
	
	@PostMapping //parametro do Json que defino o uso do metodo Post do http, para enviar dados
	/*
	 * Como se trata de uma inserção de dados o correto é retornar o status 201, que no http siginifica a criação de um novo recurso
	 * para isso é necessário chamar o metodo created do Response o qual prescisa de uma URI para ser executada;
	 * */
	public ResponseEntity<User>insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
