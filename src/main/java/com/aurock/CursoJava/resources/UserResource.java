package com.aurock.CursoJava.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurock.CursoJava.entities.User;

@RestController //parametro do fremework que define que a class é um rest de algun recurso, no caso User
@RequestMapping(value ="/users")//parametro que define o nome usado para requisitar o recurso, informando o caminho do recurso	
public class UserResource {
	
	@GetMapping //parametro que define o metodo que será executado quando houver a requisição do tipo GET definida em RequestMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria","maria@gmail.com","999999999","123456");
		return ResponseEntity.ok().body(u);
	}
}
