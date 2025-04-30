package com.sales.demo.repository;

import org.springframework.stereotype.Repository;

import com.sales.demo.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
