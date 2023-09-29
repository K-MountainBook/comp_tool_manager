package com.kmountain.comp_tool_manager.controller.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.entity.NumberingMaster;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;
import com.kmountain.comp_tool_manager.util.ProjectUtility;

/**
 * REST API用コントローラ
 * 
 * @author k_yamamoto
 *
 */
@RestController
@RequestMapping("api/v1/")
public class RestApiController {

	private final CategoryService categoryService;

	private final NumberingMasterService numberingMasterService;

	@Autowired
	public RestApiController(NumberingMasterService numberingMasterService, CategoryService categoryService) {
		this.numberingMasterService = numberingMasterService;
		this.categoryService = categoryService;
	}

	/**
	 * カテゴリから採番可能な番号を取得
	 * 
	 * @param cat カテゴリ番号
	 * @return カテゴリ番号で採番可能な番号を取得（最も低い番号を取得）
	 */
	@RequestMapping("numbering/{cat}")
	public String get(@PathVariable String cat) {
		String result = "";
		// 引数が"0"の場合はカテゴリ無しという事で空白を返却
		if (cat.equals("0")) {
			return "";
		}

		try {
			// 引数で指定されたカテゴリを元に未採番の番号を取得する
			NumberingMaster temp = numberingMasterService.getNumber(cat);
			// byteとshortで抽出するので結合して文字列にして返す。
			result = ProjectUtility.numberringToString(temp.getCategory(), (short) (temp.getNumber() + 1));
		} catch (NumberFormatException ne) {
			result = "";
		}
		return result;
	}

	/**
	 * 大分類から中分類を取得するREST API
	 * 
	 * @param cat 大分類カテゴリNo
	 * @return JSON
	 */
	@RequestMapping("subcategory/{cat}")
	public String getSubCategory(@PathVariable String cat) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Jdk8Module());

		List<Category> subCategoryList = categoryService.getSubCategory(cat);
		// System.out.println(subCategoryList.get());

		try {

			result = mapper.writeValueAsString(subCategoryList);

		} catch (Exception e) {

		}

		return result;
	}

	/**
	 * 大分類と中分類から小分類を取得するREST API
	 * 
	 * @param cat 大分類カテゴリNo
	 * @return JSON
	 */
	@RequestMapping("subcategory/{cat}/{scat}")
	public String getSSubCategory(@PathVariable String cat, @PathVariable String scat) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Jdk8Module());

		List<Category> sSubCategoryList = categoryService.getsSubCategory(cat, scat);
		// System.out.println(subCategoryList.get());

		try {

			result = mapper.writeValueAsString(sSubCategoryList);

		} catch (Exception e) {

		}

		return result;
	}

}
