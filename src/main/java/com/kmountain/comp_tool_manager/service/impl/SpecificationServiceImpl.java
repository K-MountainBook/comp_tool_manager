package com.kmountain.comp_tool_manager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.Specification;
import com.kmountain.comp_tool_manager.repository.SpecificationRepository;
import com.kmountain.comp_tool_manager.service.SpecificationService;

@Service
public class SpecificationServiceImpl implements SpecificationService {

	private final SpecificationRepository specificationRepository;

	@Autowired
	public SpecificationServiceImpl(SpecificationRepository specificationRepository) {
		this.specificationRepository = specificationRepository;
	}

	@Override
	public Optional<Specification> findById(String productId) {
		return specificationRepository.findById(productId);
	}

	@Override
	public Specification addSpecification(String productId) {

		Specification specification = new Specification();

		specification.setProductId(productId);
		specification.setCommonInfo("");

		Specification result = specificationRepository.save(specification);

		return result;
	}

}
