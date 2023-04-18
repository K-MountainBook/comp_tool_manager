package com.kmountain.comp_tool_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("add")
public class AddController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String lendGet() {
		String template = "add";

		return template;
	}
}
