package com.kmountain.comp_tool_manager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.entity.CategoryKey;
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

	public Optional<Category> findById(CategoryKey categorykey) {
		return categoryRepository.findById(categorykey);

	}

	@Override
	public Category save(Category catUpdateData) {
		Category result = categoryRepository.save(catUpdateData);
		return result;

	}

	@Override
	public List<Category> getSubCategory(String cat) {
		// TODO 自動生成されたメソッド・スタブ
		List<Category> result = categoryRepository.findBycatNumber(cat);

		return result;

	}

	@Override
	public Optional<Category> getsSubCategory(String cat, String scat) {
		Optional<Category> result = categoryRepository.findBycatNumberAndSubCatNumber(cat, scat);
		return result;
	}

}
