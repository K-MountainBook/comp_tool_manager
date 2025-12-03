package com.kmountain.comp_tool_manager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String category;

	private Short number;

}