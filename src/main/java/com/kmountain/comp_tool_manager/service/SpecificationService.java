package com.kmountain.comp_tool_manager.service;

import java.util.Optional;

import com.kmountain.comp_tool_manager.entity.Specification;

public interface SpecificationService {

	public Optional<Specification> findById(String productId);

	public Specification addSpecification(String specification);

}
