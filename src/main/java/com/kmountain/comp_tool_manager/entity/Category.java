package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "category")
@IdClass(value = CategoryKey.class)
/**
 * 備品カテゴリマスタ
 * 
 * @author k_yamamoto
 *
 */
public class Category {

	@Id
	private String catNumber;

	private String catName;
	@Id
	private String subCatNumber;

	private String subCatName;
	@Id
	private String sSubCatNumber;

	private String sSubCatName;

	private String prefixNumber;

}
