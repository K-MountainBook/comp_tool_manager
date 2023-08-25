package com.kmountain.comp_tool_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmountain.comp_tool_manager.entity.LendStatus;
import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.service.LendStatusService;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Controller
@RequestMapping("discard")
public class DisposeController {

	ToolsService toolsService;

	LendStatusService lendStatusService;

	@Autowired
	public DisposeController(ToolsService toolsService, LendStatusService lendStatusService) {
		this.toolsService = toolsService;
		this.lendStatusService = lendStatusService;
	}

	// TODO 廃棄処理
	public void dispose(List<Tools> disposeItems) {

		for (Tools t : disposeItems) {
			t.setLendStatus(lendStatusService.getStatus(LendStatus.CODE_99));
			toolsService.updateToolInfo(t);
		}

	}
	// TODO 廃棄戻し処理→これはいいかな管理者利用

}
