package com.kmountain.comp_tool_manager.form;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AddForm {

	/**
	 * ID→自動採番
	 */
	@Id
	private String lendId;
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
	private String specification;
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
	 * 常設備品
	 */
	private boolean lend_ng;
	/**
	 * 備考
	 */
	private String remarks;

	/**
	 * 遷移元ページ区別
	 */
	private String stat;
}
