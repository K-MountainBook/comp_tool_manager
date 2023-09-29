package com.kmountain.comp_tool_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmountain.comp_tool_manager.entity.NumberingMaster;

public interface NumberingMasterRepository extends JpaRepository<NumberingMaster, String> {

}
