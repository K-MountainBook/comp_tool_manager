package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.form.RemoveForm;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Controller
@RequestMapping("remove")
public class RemoveController {

	ToolsService tools_service;

	public RemoveController(ToolsService tools_service) {
		this.tools_service = tools_service;
	}

	@ModelAttribute("rf")
	RemoveForm makeRemoveForm() {
		return new RemoveForm();
	}

	@GetMapping("")
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
	@PostMapping("")
	public ModelAndView post(ModelAndView mav, RemoveForm rf) {

		// System.out.println(rf);
		List<String> items = rf.getRemoveItem();

		List<Tools> removeItems = tools_service.findToolsByIdsIn(items);

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
	@PostMapping("execute")
	public ModelAndView removeExec(ModelAndView mav, RemoveForm rf) {
		// System.out.println(rf);

		List<String> items = rf.getRemoveItem();

		tools_service.removeTools(items);

		mav.setViewName("removeComplete");
		return mav;
	}
}
