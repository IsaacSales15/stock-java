package com.sales.demo.service;

import com.sales.demo.model.Category;
import com.sales.demo.model.User;
import com.sales.demo.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;
    private final Category category;

    public CategoryService(Category category, CategoryRepository categoryRepository){
        this.category = category;
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new RuntimeException("Category not found with id: " + id)); 
    }

    public void delete(Long id){
        Optional<Category> category = categoryRepository.findById(id);

        Category exists = category.orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepository.delete(exists);
    }

}
