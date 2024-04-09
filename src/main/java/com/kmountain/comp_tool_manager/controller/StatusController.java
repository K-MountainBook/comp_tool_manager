package com.kmountain.comp_tool_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("status")
public class StatusController {

	@GetMapping("")
	public String get() {
		String template = "status";

		return template;
	}
}
