package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.form.AddForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;

@Controller
@RequestMapping("add")
public class AddController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	NumberingMasterService numberingMasterService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String lendGet(Model model) {
		String template = "add";
		AddForm form = new AddForm();

		List<Category> category = categoryService.findAll();

		form.setLendId("");

		model.addAttribute("tool", form);
		model.addAttribute("categoryList", category);

		return template;
	}

}
