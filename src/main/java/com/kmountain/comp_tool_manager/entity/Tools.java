package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "tools")
public class Tools {

	/**
	 * ID
	 */
	@Id
	private String lendId;

	/**
	 * カテゴリ
	 */
	private Integer category;
	/**
	 * 	メーカー
	 */
	private String maker;
	/**
	 * 一般名or型式
	 */
	private String productId;
	/**
	 *	管理名称 
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
	 * 長期貸出先
	 */
	private String lendTo;
	/**
	 * 備考
	 */
	private String remarks;

}
