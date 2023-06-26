package com.kmountain.comp_tool_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("remove")
public class RemoveController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get() {
		String template = "remove";

		return template;
	}
}
