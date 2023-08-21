package com.kmountain.comp_tool_manager.service;

import java.util.List;
import java.util.Optional;

import com.kmountain.comp_tool_manager.entity.Category;

public interface CategoryService {

	public List<Category> findAll();

	public Optional<Category> findById(Integer category);

	public Category save(Category catUpdateData);

}
