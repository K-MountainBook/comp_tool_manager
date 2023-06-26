package com.kmountain.comp_tool_manager.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public RestApiController(NumberingMasterService numberingMasterService) {
		this.numberingMasterService = numberingMasterService;
	}

	/**
	 * カテゴリから採番可能な番号を取得
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
			NumberingMaster temp = numberingMasterService.getNumber(Byte.parseByte(cat));
			// byteとshortで抽出するので結合して文字列にして返す。
			result = ProjectUtility.numberringToString(temp.getCategory(), temp.getNumber());
		} catch (NumberFormatException ne) {
			result = "";
		}
		return result;
	}

}
