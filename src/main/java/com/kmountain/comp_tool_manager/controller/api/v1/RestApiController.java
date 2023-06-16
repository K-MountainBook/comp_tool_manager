package com.kmountain.comp_tool_manager.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmountain.comp_tool_manager.entity.NumberingMaster;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;
import com.kmountain.comp_tool_manager.util.ProjectUtility;

@RestController
@RequestMapping("api/v1/")
public class RestApiController {

	private final NumberingMasterService numberingMasterService;

	@Autowired
	public RestApiController(NumberingMasterService numberingMasterService) {
		this.numberingMasterService = numberingMasterService;
	}

	@RequestMapping("numbering/{cat}")
	public String get(@PathVariable String cat) {
		if (cat.equals("0")) {
			return "";
		}
		NumberingMaster temp = numberingMasterService.getNumber(Byte.parseByte(cat));
		return ProjectUtility.numberringToString(temp.getCategory(), temp.getNumber());
	}

}
