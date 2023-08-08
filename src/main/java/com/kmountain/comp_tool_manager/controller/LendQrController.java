package com.kmountain.comp_tool_manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.controller.bean.MessageBean;
import com.kmountain.comp_tool_manager.exception.NotExistsItemException;
import com.kmountain.comp_tool_manager.form.LendQrForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.LendService;

@Controller
@RequestMapping("lendqr")
public class LendQrController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	LendService lendService;

	@Autowired
	public LendQrController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ModelAttribute("qrform")
	LendQrForm makeQrFrom() {
		return new LendQrForm();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get(ModelAndView mav) {

		mav.setViewName("lendqr");

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView post(ModelAndView mav, LendQrForm qrform) {

		String result = "";
		List<MessageBean> msgList = new ArrayList<>();
		mav.setViewName("lendqr");

		if (qrform.getUser().equals("")) {
			// ユーザの入力が無かった場合はそのまま画面を戻す
			msgList.add(new MessageBean(MessageBean.CAT_INFO, "貸出ユーザを選択してください。"));
			mav.addObject("msg", msgList);
			mav.addObject("qrform", qrform);
			return mav;
		}

		try {
			// 貸出状態のチェック
			boolean lendCheck;
			lendCheck = lendService.lendCheck(qrform.getItemNumber());

			// 貸出状態とラジオボタンの選択で処理を決定
			if (lendCheck && qrform.getLendcat().equals("kashi_dashi")) {
				// 貸出処理
				System.out.println("貸出処理");
				lendService.kashidashi(qrform.getItemNumber(), qrform.getUser());
			} else if (!lendCheck && qrform.getLendcat().equals("hen_kyaku")) {
				// 返却処理
				System.out.println("返却処理");
				lendService.henkyaku(qrform.getItemNumber(), qrform.getUser());
			} else {
				if (lendCheck) {
					System.out.println("返却されています。");
					msgList.add(new MessageBean(MessageBean.CAT_INFO, "既に返却されています。"));
					mav.addObject("qrform", qrform);
				} else {
					System.out.println("貸出中です。");
					msgList.add(new MessageBean(MessageBean.CAT_INFO, "既に貸出されています。"));
					mav.addObject("qrform", qrform);
				}
			}

		} catch (NotExistsItemException e) {
			System.err.println("読み込まれたQRコードの備品が存在しません。");
			msgList.add(new MessageBean(MessageBean.CAT_ERR, "読み込まれたQRコードの備品が存在しません。"));
		} catch (Exception e) {
			e.printStackTrace();
			msgList.add(new MessageBean(MessageBean.CAT_CRI, "致命的なエラーが発生しました。管理者に問い合わせてください。"));

		}

		mav.addObject("result", result);
		mav.addObject("msg", msgList);

		return mav;
	}

}
