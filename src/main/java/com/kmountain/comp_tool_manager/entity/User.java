package com.kmountain.comp_tool_manager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "user")
/**
 * ユーザ情報テーブル
 * @author k_yamamoto
 *
 */
public class User {

	@Id
	/**
	 * ユーザID
	 */
	private String userId;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 有効/無効
	 */
	private Boolean enabled;

}
