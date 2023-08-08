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
	 * 0:保管中
	 * 1:貸出中
	 * 2:長期貸し出し中
	 * 9:修理・故障中
	 */
	private String lendStatus;
}
