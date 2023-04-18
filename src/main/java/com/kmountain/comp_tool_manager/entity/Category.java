package com.kmountain.comp_tool_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "manager", name = "category")
public class Category {

	@Id
	private Integer catNumber;

	private String catName;

}
