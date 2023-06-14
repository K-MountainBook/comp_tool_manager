package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "number_manager")
/**
 * 採番マスタ
 * 
 * @author k_yamamoto
 *
 */
public class NumberingMaster {

	@Id
	private Byte category;

	private Short number;

}