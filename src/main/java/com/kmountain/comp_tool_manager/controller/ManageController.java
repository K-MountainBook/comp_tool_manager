package com.kmountain.comp_tool_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("manage")
public class ManageController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String manageGet() {
		String template = "manage";

		return template;
	}

}
