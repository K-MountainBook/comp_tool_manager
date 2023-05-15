package com.kmountain.comp_tool_manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.repository.ToolsRepository;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Service
public class ToolsServiceImpl implements ToolsService {

	private final ToolsRepository toolsRepository;

	@Autowired
	public ToolsServiceImpl(ToolsRepository toolsRepository) {
		this.toolsRepository = toolsRepository;
	}

	/**
	 * Toolsテーブルの全検索
	 * 
	 * @return List{@literal <}{@link Tools}{@literal }>
	 * 
	 */
	public List<Tools> findAll() {
		return toolsRepository.findAll();
	}
}
