package com.kmountain.comp_tool_manager.service;

import java.util.List;
import java.util.Optional;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.entity.CategoryKey;
import com.kmountain.comp_tool_manager.service.column.CategoryNumberOnly;

public interface CategoryService {

	public List<Category> findAll();

	public Optional<Category> findById(CategoryKey categoryKey);

	public Category save(Category catUpdateData);

	public List<Category> getSubCategory(String cat);

	public Optional<Category> getsSubCategory(String cat, String scat);

	public List<CategoryNumberOnly> findCatNumberByAll();

}
