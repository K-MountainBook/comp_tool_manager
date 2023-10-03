package com.kmountain.comp_tool_manager.form;

import lombok.Data;

@Data
public class SearchForm {
	/**
	 * カテゴリ
	 */
	private String category;
	/**
	 * カテゴリ
	 */
	private String subCategory;
	/**
	 * カテゴリ
	 */
	private String sSubCategory;
	/**
	 * メーカー
	 */
	private String maker;
	/**
	 * 一般名or型式
	 */
	private String String;
	/**
	 * 管理名称
	 */
	private String managementName;
	/**
	 * 追加情報
	 */
	private String anotherInfo;
	/**
	 * 保管/常備場所
	 */
	private String keepPlace;
	/**
	 * 備考
	 */
	private String remarks;

}
