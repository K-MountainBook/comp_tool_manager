package com.kmountain.comp_tool_manager.util;

public class ProjectUtility {
	/**
	 * 
	 * @param prefix 接頭番号２桁
	 * @param number 通し番号４桁
	 * @return
	 */
	public static String numberringToString(Byte prefix, Short number) {

		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%02d", prefix));
		sb.append(String.format("%04d", number));

		return sb.toString();
	}
}
