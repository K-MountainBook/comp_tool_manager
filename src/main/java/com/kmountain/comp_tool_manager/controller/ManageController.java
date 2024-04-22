package com.kmountain.comp_tool_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Controller
@RequestMapping("manage")
public class ManageController {

	@Autowired
	ToolsService tools_service;

	@GetMapping("")
	public String get(Pageable pageable, Model model) {
		String template = "manage";

		Page<Tools> toolAll = tools_service.findAll(pageable);

		model.addAttribute("data", toolAll);

		return template;
	}

}
