package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "category")
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

	private String prefixNumber;

}
