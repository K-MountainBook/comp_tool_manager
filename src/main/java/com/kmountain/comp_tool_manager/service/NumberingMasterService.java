package com.kmountain.comp_tool_manager.service;

import com.kmountain.comp_tool_manager.entity.NumberingMaster;

public interface NumberingMasterService {

	public NumberingMaster getNumber(String catByteType);

	public NumberingMaster save(NumberingMaster numberingMaster);

}
