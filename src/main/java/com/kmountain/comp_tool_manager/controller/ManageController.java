package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Controller
@RequestMapping("manage")
public class ManageController {

	@Autowired
	ToolsService tools_service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(Model model) {
		String template = "manage";

		List<Tools> toolAll = tools_service.findAll();

		model.addAttribute("data", toolAll);
		
		return template;
	}

}
