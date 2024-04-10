package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.form.AddForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;
import com.kmountain.comp_tool_manager.service.column.CategoryNumberOnly;
import com.kmountain.comp_tool_manager.service.column.SSubCategoryNumberOnly;
import com.kmountain.comp_tool_manager.service.column.SubCategoryNumberOnly;

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

	private static final Logger log = LoggerFactory.getLogger(AddController.class);

	/**
	 * method get
	 * 
	 * @param mav ModelAndView
	 * @return ModelAndView(view name : add)
	 */
	@GetMapping("")
	public ModelAndView get(ModelAndView mav, @ModelAttribute("tool") AddForm form) {
		mav.setViewName("add");

		List<CategoryNumberOnly> category = categoryService.findCatNumberByAll();

		//		System.out.println(category.get(0).getCatNumber());

		mav.addObject("categoryList", category);

		return mav;
	}

	/**
	 * 
	 * @param mav
	 * @param form
	 * @return
	 */
	@PostMapping("")
	public ModelAndView post(ModelAndView mav, @ModelAttribute("tool") AddForm form) {
		// System.out.println(form);
		// トグルスイッチONがTrue
		log.info("トグルスイッチ:" + form.isLend_ng());

		List<SubCategoryNumberOnly> subCategoryList = null;
		List<SSubCategoryNumberOnly> sSubCategoryList = null;
		// カテゴリ一覧を作成
		List<Category> category = categoryService.findAll();

		// 中分類と小分類が設定されていた場合はその値をセットできるようにするためデータを取り出す。
		if (!form.getCategory().equals("0")) {
			subCategoryList = categoryService.findSubCatNumberByCatNumber(form.getCategory());

			if (!form.getSubCategory().equals("0")) {
				sSubCategoryList = categoryService.findSSubCatNumberByACatNumberAndSubCatNumber(form.getCategory(),
						form.getSubCategory());

				for (SSubCategoryNumberOnly i : sSubCategoryList) {
					log.info("サブカテゴリ名:" + i.getsSubCatName());
					log.info("サブカテゴリ番号:" + i.getsSubCatNumber());
				}
			}

		}

		mav.addObject("categoryList", category);
		mav.addObject("subCategoryList", subCategoryList);
		mav.addObject("sSubCategoryList", sSubCategoryList);

		mav.setViewName("addconfirm");

		return mav;
	}
}
