package com.kmountain.comp_tool_manager.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kmountain.comp_tool_manager.entity.Tools;

public interface ToolsService {

	public Page<Tools> findAll(Pageable pageable);

	public void removeTools(List<String> itemIds);

	public Tools updateToolInfo(Tools tools);

	public List<Tools> findToolsByIdsStartingWith(String items);
	
	public List<Tools> findToolsByIdsIn(List<String> items);

}
