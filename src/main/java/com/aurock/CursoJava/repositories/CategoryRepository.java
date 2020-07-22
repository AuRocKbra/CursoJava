package com.aurock.CursoJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurock.CursoJava.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
