	package com.aurock.CursoJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurock.CursoJava.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	/*
	 * Classe da camada repository que herda as funções do JPA repository, permitindo realizar as operações dos atributos da entidade
	 * User
	 * */
}
