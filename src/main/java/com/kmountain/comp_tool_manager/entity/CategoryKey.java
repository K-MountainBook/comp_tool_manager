package com.kmountain.comp_tool_manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 備品カテゴリマスタKey
 * 
 * @author k_yamamoto
 *
 */
public class CategoryKey {

	private String catNumber;

	private String subCatNumber;

	private String sSubCatNumber;

}
