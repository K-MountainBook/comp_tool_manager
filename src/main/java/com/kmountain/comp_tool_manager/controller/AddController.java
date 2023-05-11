package com.kmountain.comp_tool_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kmountain.comp_tool_manager.form.AddForm;

@Controller
@RequestMapping("add")
public class AddController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String lendGet(Model model) {
		model.addAttribute("tool", new AddForm());
		String template = "add";

		return template;
	}
}
