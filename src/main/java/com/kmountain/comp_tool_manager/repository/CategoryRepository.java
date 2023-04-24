package com.kmountain.comp_tool_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmountain.comp_tool_manager.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
