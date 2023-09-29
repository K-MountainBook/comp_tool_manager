package com.kmountain.comp_tool_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.entity.CategoryKey;
import com.kmountain.comp_tool_manager.service.column.CategoryNumberOnly;

public interface CategoryRepository extends JpaRepository<Category, CategoryKey> {

	List<Category> findBycatNumber(String cat);

	List<CategoryNumberOnly> findDistinctCatNumberByCatNumberLike(String cat);

	List<Category> findBycatNumberAndSubCatNumber(String cat, String scat);

}
