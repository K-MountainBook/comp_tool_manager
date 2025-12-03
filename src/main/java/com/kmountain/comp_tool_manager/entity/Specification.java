package com.kmountain.comp_tool_manager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "specification")
/**
 * 型番に対する共通情報テーブル
 * 
 * @author k_yamamoto
 *
 */
public class Specification {

	@Id
	private String productId;

	private String commonInfo;

}
