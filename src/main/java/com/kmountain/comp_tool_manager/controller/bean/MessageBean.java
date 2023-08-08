package com.kmountain.comp_tool_manager.controller.bean;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MessageBean {

	public static final String CAT_INFO = "info";
	public static final String CAT_WARN = "warn";
	public static final String CAT_ERR = "err";
	public static final String CAT_CRI = "critical";

	private String msgCategory;
	private String message;

}
