package com.kmountain.comp_tool_manager.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmountain.comp_tool_manager.entity.Specification;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, String> {

}
