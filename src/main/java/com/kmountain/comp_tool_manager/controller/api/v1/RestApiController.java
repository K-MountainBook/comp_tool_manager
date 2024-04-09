package com.kmountain.comp_tool_manager.controller.api.v1;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> 63d1c9b68ff097b1f3da5c9878cd007592d0dce8
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmountain.comp_tool_manager.entity.NumberingMaster;
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

	private final NumberingMasterService numberingMasterService;

	public RestApiController(NumberingMasterService numberingMasterService) {
		this.numberingMasterService = numberingMasterService;
	}

	/**
	 * カテゴリから採番可能な番号を取得
	 * 
	 * @param cat カテゴリ番号
	 * @return カテゴリ番号で採番可能な番号を取得（最も低い番号を取得）
	 */
	@GetMapping("numbering/{cat}")
	public String getNumbering(@PathVariable String cat) {
		String result = "";

		// 引数が"0"の場合はカテゴリ無しという事で空白を返却
		if (cat.equals("0")) {
			return "";
		}

		try {
			// 引数で指定されたカテゴリを元に未採番の番号を取得する
			// TODO:log4jを入れましょう
			NumberingMaster selectResult = numberingMasterService.getNumber(cat);

			result = cat + String.format("%03d", selectResult.getNumber() + 1);

		} catch (NumberFormatException e) {
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
	@GetMapping("subcategory/{cat}")
	public String getSubCategory(@PathVariable String cat) {
		return ProjectUtility.getSubCategory(cat);
	}

	/**
	 * 大分類と中分類から小分類を取得するREST API
	 * 
	 * @param cat 大分類カテゴリNo
	 * @return JSON
	 */
	@GetMapping("subcategory/{cat}/{scat}")
	public String getSSubCategory(@PathVariable String cat, @PathVariable String scat) {
		return ProjectUtility.getSSubCategory(cat, scat);
	}

}
