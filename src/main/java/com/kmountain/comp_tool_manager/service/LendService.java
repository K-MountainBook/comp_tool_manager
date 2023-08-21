package com.kmountain.comp_tool_manager.service;

import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.exception.NotExistsItemException;

public interface LendService {

	/**
	 * 
	 * 貸出状態のチェック
	 *
	 * @param itemId 備品ID
	 * @return 貸出中であればfalse
	 * @throws NotExistsItemException 
	 */
	public boolean lendCheck(String itemId) throws NotExistsItemException;

	/**
	 * 貸出処理
	 * @param itemNumber
	 * @param user
	 */
	public void kashidashi(String itemNumber, String user);

	/**
	 * 返却処理
	 * @param itemNumber
	 * @param user
	 */
	public void henkyaku(String itemNumber, String user);

	public boolean register(Tools tools);

}
