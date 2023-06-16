package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView lendGet(ModelAndView mav) {
		mav.setViewName("add");
		AddForm form = new AddForm();

		List<Category> category = categoryService.findAll();

		form.setLendId("");

		mav.addObject("tool", form);
		mav.addObject("categoryList", category);

		return mav;
	}

}
