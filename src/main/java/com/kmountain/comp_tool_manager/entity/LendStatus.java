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
	 * 保管中
	 */
	public static final String CODE_0 = "0";

	/**
	 * 貸出中
	 */
	public static final String CODE_1 = "1";

	/**
	 * 長期貸出中
	 */
	public static final String CODE_2 = "2";

	/**
	 * 故障・修理中
	 */
	public static final String CODE_9 = "9";

	/**
	 * 破棄
	 */
	public static final String CODE_99 = "99";

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
	 * 99:破棄
	 */
	private String lendStatus;
}
