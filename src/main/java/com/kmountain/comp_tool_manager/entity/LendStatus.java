package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "lend_status")
public class LendStatus {

	/**
	 * ID
	 */
	@Id
	private String lendId;

	/**
	 * 貸出状態
	 */
	private Byte lendStatus;
}
