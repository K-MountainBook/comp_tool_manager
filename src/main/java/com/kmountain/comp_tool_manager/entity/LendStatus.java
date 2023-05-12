package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "lend_status")
/**
 * 貸出状況
 * 
 * @author k_yamamoto
 *
 */
public class LendStatus {

	/**
	 * code
	 */
	@Id
	private String code;

	/**
	 * 貸出状態
	 */
	private String lendStatus;
}
