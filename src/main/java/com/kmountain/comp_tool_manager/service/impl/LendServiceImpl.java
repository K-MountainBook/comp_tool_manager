package com.kmountain.comp_tool_manager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmountain.comp_tool_manager.entity.LendStatus;
import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.exception.NotExistsItemException;
import com.kmountain.comp_tool_manager.repository.ToolsRepository;
import com.kmountain.comp_tool_manager.service.LendService;

@Service
public class LendServiceImpl implements LendService {

	private final ToolsRepository toolsRepository;

	@Autowired
	public LendServiceImpl(ToolsRepository toolsRepository) {
		this.toolsRepository = toolsRepository;
	}

	@Override
	public boolean lendCheck(String itemId) throws NotExistsItemException {

		boolean returnValue = false;

		Optional<Tools> resultSet = toolsRepository.findById(itemId);

		if (resultSet.isEmpty()) {
			// 値が取得できない場合はおかしいので例外を返す
			throw new NotExistsItemException("アイテム" + itemId + "は存在しません。");

		} else {
			Tools result = resultSet.get();
			if (result.getLendStatus().getCode().equals(LendStatus.CODE_0)) {
				returnValue = true;
			}
		}

		return returnValue;
	}

	@Override
	public void kashidashi(String itemNumber, String user) {

		Optional<Tools> item = toolsRepository.findById(itemNumber);
		item.get().setLendTo(user);
		item.get().getLendStatus().setCode("1");
		toolsRepository.saveAndFlush(item.get());

	}

	@Override
	public void henkyaku(String itemNumber, String user) {

		Optional<Tools> item = toolsRepository.findById(itemNumber);
		item.get().setLendTo("");
		item.get().getLendStatus().setCode("0");
		toolsRepository.saveAndFlush(item.get());
	}

	@Override
	public boolean register(Tools tools) {
		boolean result = false;
		toolsRepository.save(tools);
		Optional<Tools> findSet = toolsRepository.findById(tools.getLendId());
		if (!findSet.isEmpty()) {
			result = true;
		}
		return result;
	}

}
