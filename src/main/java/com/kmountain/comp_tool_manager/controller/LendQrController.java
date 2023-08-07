package com.kmountain.comp_tool_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.form.LendQrForm;
import com.kmountain.comp_tool_manager.service.CategoryService;

@Controller
@RequestMapping("lendqr")
public class LendQrController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	public LendQrController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get(ModelAndView mav) {
		LendQrForm qrform = new LendQrForm();

		mav.addObject("qrform", qrform);
		mav.setViewName("lendqr");

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView post(ModelAndView mav, LendQrForm qrform) {
		String result = "";

		mav.addObject("result", result);
		mav.setViewName("lendqr");

		return mav;
	}
}
