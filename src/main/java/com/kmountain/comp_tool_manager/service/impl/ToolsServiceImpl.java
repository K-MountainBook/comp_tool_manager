package com.kmountain.comp_tool_manager.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Tools> findAll(Pageable pageable) {
		return toolsRepository.findAll(pageable);
	}

	/**
	 * 備品の検索(id指定)
	 */
	@Override
	public List<Tools> findToolsByIdsStartingWith(String items) {
		return toolsRepository.findBylendIdStartingWith(items);
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

	@Override
	public List<Tools> findToolsByIdsIn(List<String> items) {
		return toolsRepository.findBylendIdIn(items);
	}

}
