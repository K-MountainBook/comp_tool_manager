package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "tools")
/**
 * 備品テーブル
 * 
 * @author k_yamamoto
 *
 */
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
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private Specification specification;
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
