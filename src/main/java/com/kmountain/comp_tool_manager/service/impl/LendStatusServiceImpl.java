package com.kmountain.comp_tool_manager.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.LendStatus;
import com.kmountain.comp_tool_manager.repository.LendStatusRepository;
import com.kmountain.comp_tool_manager.service.LendStatusService;

@Service
public class LendStatusServiceImpl implements LendStatusService {

	private final LendStatusRepository lendStatusRepository;

	public LendStatusServiceImpl(LendStatusRepository lendStatusRepository) {
		this.lendStatusRepository = lendStatusRepository;
	}

	@Override
	public LendStatus getStatus(String id) {
		Optional<LendStatus> result = lendStatusRepository.findById(id);
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get();
		}
	}

}
