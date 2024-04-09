package com.kmountain.comp_tool_manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.repository.ToolsRepository;
import com.kmountain.comp_tool_manager.service.ToolsService;

@Service
public class ToolsServiceImpl implements ToolsService {

	private final ToolsRepository toolsRepository;

	public ToolsServiceImpl(ToolsRepository toolsRepository) {
		this.toolsRepository = toolsRepository;
	}

	/**
	 * Toolsテーブルの全検索
	 * 
	 * @return List{@literal <}{@link Tools}{@literal }>
	 * 
	 */
	public List<Tools> findAll() {
		return toolsRepository.findAll();
	}

	/**
	 * 備品の検索(id指定)
	 */
	@Override
	public List<Tools> findToolsByIds(List<String> items) {
		return toolsRepository.findAllById(items);
	}

	/**
	 * 備品の削除
	 */
	@Override
	public void removeTools(List<String> itemIds) {
		toolsRepository.deleteAllById(itemIds);

	}

	/**
	 * 備品の更新
	 */
	@Override
	public Tools updateToolInfo(Tools tools) {
		Tools result = toolsRepository.save(tools);
		return result;
	}
}
