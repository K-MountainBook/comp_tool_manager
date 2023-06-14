package com.kmountain.comp_tool_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.NumberingMaster;
import com.kmountain.comp_tool_manager.repository.NumberingMasterRepository;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;

@Service
public class NumberingMasterServiceImpl implements NumberingMasterService {

	private final NumberingMasterRepository numberingMasterRepository;

	@Autowired
	public NumberingMasterServiceImpl(NumberingMasterRepository numberingMasterRepository) {
		this.numberingMasterRepository = numberingMasterRepository;
	}

	@Override
	public NumberingMaster getNumber(Byte category) {
		return numberingMasterRepository.findById(category).orElseThrow();
	}

}
