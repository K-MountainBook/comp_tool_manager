package com.kmountain.comp_tool_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmountain.comp_tool_manager.entity.Specification;
import com.kmountain.comp_tool_manager.entity.Tools;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, String> {

	List<Tools> findBySpecification(Specification specification);
}
