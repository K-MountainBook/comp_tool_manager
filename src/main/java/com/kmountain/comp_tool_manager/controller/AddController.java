package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.form.AddForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;

/**
 * 備品追加コントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("add")
public class AddController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	NumberingMasterService numberingMasterService;

	@ModelAttribute("tool")
	AddForm makeAddForm() {
		// TODO 毎回呼ばれるたびに初期化されるらしく意味不明。要調査。
		return new AddForm();
	}

	/**
	 * method get
	 * @param mav ModelAndView
	 * @return ModelAndView(view name : add)
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get(ModelAndView mav) {
		mav.setViewName("add");

		List<Category> category = categoryService.findAll();

		mav.addObject("categoryList", category);

		return mav;
	}

	/**
	 * method post
	 * @param mav ModelAndView
	 * @param form Bean
	 * @return ModelAndView
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView post(ModelAndView mav, AddForm form) {
		System.out.println(form);

		// カテゴリ一覧を作成
		List<Category> category = categoryService.findAll();

		mav.addObject("categoryList", category);

		// 確認画面のため、入力された内容を改めてフォームに格納
		mav.addObject("tool", form);

		mav.setViewName("addconfirm");

		return mav;
	}
}
