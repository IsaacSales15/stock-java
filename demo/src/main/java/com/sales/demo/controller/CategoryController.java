package com.sales.demo.controller;

import com.sales.demo.model.Category;
import com.sales.demo.service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
class CategoryController {

    public CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAll(){
        return  categoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
