package com.kmountain.comp_tool_manager.service;

import java.util.List;

import com.kmountain.comp_tool_manager.entity.Tools;

public interface ToolsService {

	public List<Tools> findAll();

	public void removeTools(List<String> itemIds);

	public Tools updateToolInfo(Tools tools);

	public List<Tools> findToolsByIdsStartingWith(String items);
	
	public List<Tools> findToolsByIdsIn(List<String> items);

}
