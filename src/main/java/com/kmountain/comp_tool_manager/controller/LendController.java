package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.form.SearchForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.column.CategoryNumberOnly;
import com.kmountain.comp_tool_manager.service.column.SSubCategoryNumberOnly;
import com.kmountain.comp_tool_manager.service.column.SubCategoryNumberOnly;

@Controller
@RequestMapping("lend")
public class LendController {

	CategoryService categoryService;

	public LendController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("")
	public ModelAndView get(ModelAndView mav, @ModelAttribute SearchForm searchForm) {
		mav.setViewName("lend");

		// 大分類の番号と名前を取得
		List<CategoryNumberOnly> category = categoryService.findCatNumberByAll();

		System.out.println(category);

		mav.addObject("searchform", searchForm);
		mav.addObject("categoryList", category);

		return mav;
	}

	@PostMapping("")
	public ModelAndView post(ModelAndView mav, SearchForm searchForm) {

		// TODO 入力された項目から検索を行う。
		String cat = searchForm.getCategory();
		String subCat = searchForm.getSubCategory();
		String sSubCat = searchForm.getSSubCategory();
		
		List<Tools> toolsList = null;
		
		List<SubCategoryNumberOnly> subCategoryList = null;
		List<SSubCategoryNumberOnly> sSubCategoryList = null;
		

		// 大分類の番号と名前を取得
		List<CategoryNumberOnly> category = categoryService.findCatNumberByAll();

		// 中分類と小分類が設定されていた場合はその値をセットできるようにするためデータを取り出す。
		if (!searchForm.getCategory().equals("0")) {
			subCategoryList = categoryService.findSubCatNumberByCatNumber(cat);

			if (!searchForm.getSubCategory().equals("0")) {
				sSubCategoryList = categoryService.findSSubCatNumberByACatNumberAndSubCatNumber(
						cat, subCat);

//				for (SSubCategoryNumberOnly i : sSubCategoryList) {
//					System.out.println(i.getsSubCatName());
//					System.out.println(i.getsSubCatNumber());
//				}
			}

		}
		
		// templateに渡すデータ
		mav.addObject("searchform", searchForm);				// 検索フォーム値
		mav.addObject("categoryList", category);				// 大項目リスト
		mav.addObject("subCategoryList", subCategoryList);		// 中項目リスト
		mav.addObject("sSubCategoryList", sSubCategoryList);	// 小項目リスト

		mav.setViewName("lend");

		return mav;
	}
}
