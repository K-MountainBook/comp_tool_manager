package com.kmountain.comp_tool_manager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.repository.CategoryRepository;
import com.kmountain.comp_tool_manager.service.CategoryService;

@Service
public class CategoryServiecImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiecImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	/**
	 * カテゴリテーブルの全検索
	 */
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Integer category) {
		return categoryRepository.findById(category);

	}

	@Override
	public Category save(Category catUpdateData) {
		Category result = categoryRepository.save(catUpdateData);
		return result;

	}

}
