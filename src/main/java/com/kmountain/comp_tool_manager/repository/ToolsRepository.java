package com.kmountain.comp_tool_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmountain.comp_tool_manager.entity.Tools;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, String> {

	//	List<Tools> findBySpecification(Specification specification);
}
