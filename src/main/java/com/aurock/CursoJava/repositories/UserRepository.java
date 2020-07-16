	package com.aurock.CursoJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurock.CursoJava.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
