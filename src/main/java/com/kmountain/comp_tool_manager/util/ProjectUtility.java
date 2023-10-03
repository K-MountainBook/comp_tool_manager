package com.kmountain.comp_tool_manager.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.kmountain.comp_tool_manager.entity.Category;
import com.kmountain.comp_tool_manager.service.CategoryService;

@Component
public class ProjectUtility {

	private static CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		ProjectUtility.categoryService = categoryService;
	}

	/**
	 * 
	 * @param string 接頭番号２桁
	 * @param number 通し番号４桁
	 * @return
	 */
	public static String numberringToString(String string, Short number) {

		StringBuilder sb = new StringBuilder();

		sb.append(string);
		sb.append(String.format("%04d", number));

		return sb.toString();
	}

	/**
	 * 小分類の取得
	 * 
	 * @param cat  大分類コード
	 * @param scat 中分類コード
	 * @return 抽出した対象分類コードのJSON
	 */
	public static String getSSubCategory(String cat, String scat) {
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

	/**
	 * 中分類の抽出
	 * 
	 * @param cat 大分類コード
	 * @return 抽出した中分類コードを含んだJSON
	 */
	public static String getSubCategory(String cat) {
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

}
