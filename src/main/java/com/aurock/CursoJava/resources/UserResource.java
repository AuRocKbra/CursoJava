package com.aurock.CursoJava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
