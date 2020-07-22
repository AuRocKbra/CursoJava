package com.aurock.CursoJava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurock.CursoJava.entities.Category;
import com.aurock.CursoJava.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}
}
