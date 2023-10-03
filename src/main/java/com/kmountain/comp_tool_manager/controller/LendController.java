package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.form.SearchForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.column.CategoryNumberOnly;

@Controller
@RequestMapping("lend")
public class LendController {

	CategoryService categoryService;

	@Autowired
	public LendController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get(ModelAndView mav) {
		mav.setViewName("lend");

		// 大分類の番号と名前を取得
		List<CategoryNumberOnly> category = categoryService.findCatNumberByAll();

		System.out.println(category);

		mav.addObject("searchform", new SearchForm());
		mav.addObject("categoryList", category);

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView post(ModelAndView mav, SearchForm search_form) {
		mav.setViewName("lend");

		return mav;
	}
}
