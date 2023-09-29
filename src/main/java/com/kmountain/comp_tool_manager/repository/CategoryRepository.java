package com.kmountain.comp_tool_manager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.entity.CategoryKey;

public interface CategoryRepository extends JpaRepository<Category, CategoryKey> {

	List<Category> findBycatNumber(String cat);

	Optional<Category> findBycatNumberAndSubCatNumber(String cat, String scat);

}
