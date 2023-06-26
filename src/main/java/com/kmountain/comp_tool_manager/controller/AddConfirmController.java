package com.kmountain.comp_tool_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.form.AddForm;

/**
 * 備品追加確認コントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("addconfirm")
public class AddConfirmController {

	/**
	 * method post
	 * @param mav ModelAndView
	 * @param form Bean
	 * @return ModelAndView
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView post(ModelAndView mav, AddForm form) {
		System.out.println(form);
		mav.setViewName("addconfirm");
		return mav;
	}
}
