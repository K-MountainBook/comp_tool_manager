package com.kmountain.comp_tool_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.controller.repository.ToolsRepository;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Service
public class ToolsServiceImpl implements ToolsService {

	@Autowired
	ToolsRepository toolsRepository;
}
