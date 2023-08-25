package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.form.RemoveForm;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Controller
@RequestMapping("remove")
public class RemoveController {

	ToolsService tools_service;

	@Autowired
	public RemoveController(ToolsService tools_service) {
		this.tools_service = tools_service;
	}

	@ModelAttribute("rf")
	RemoveForm makeRemoveForm() {
		return new RemoveForm();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get(ModelAndView mav) {

		List<Tools> toolAll = tools_service.findAll();

		mav.addObject("data", toolAll);

		mav.setViewName("remove");

		return mav;
	}

	/**
	 * 削除確認画面への移行
	 * @param mav
	 * @param rf
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView post(ModelAndView mav, RemoveForm rf) {

		// System.out.println(rf);
		List<String> items = rf.getRemoveItem();

		List<Tools> removeItems = tools_service.findToolsByIds(items);

		//		for (Tools removeItem : removeItems) {
		//			System.out.println(removeItem);
		//
		//		}

		mav.addObject("removeItems", removeItems);
		mav.setViewName("removeconfirm");

		return mav;
	}

	/**
	 * 削除の実行
	 * @param mav
	 * @param rf
	 * @return
	 */
	@RequestMapping(value = "execute", method = RequestMethod.POST)
	public ModelAndView removeExec(ModelAndView mav, RemoveForm rf) {
		// System.out.println(rf);

		List<String> items = rf.getRemoveItem();

		tools_service.removeTools(items);

		mav.setViewName("removeComplete");
		return mav;
	}
}
