package com.kmountain.comp_tool_manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	public LendQrController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ModelAttribute("qrform")
	LendQrForm makeQrFrom() {
		return new LendQrForm();
	}

	@GetMapping("")
	public ModelAndView get(ModelAndView mav) {

		mav.setViewName("lendqr");

		return mav;
	}

	/**
	 * 貸出処理
	 * @param mav
	 * @param qrform
	 * @return
	 */
	@PostMapping("checkout")
	public ModelAndView postCheckout(ModelAndView mav, LendQrForm qrform) {

		String result = "";
		List<MessageBean> msgList = new ArrayList<>();
		mav.setViewName("lendqr");

		if (!checkExistsUser(qrform)) {
			// ユーザの入力が無かった場合はそのまま画面を戻す
			msgList.add(new MessageBean(MessageBean.CAT_WARN, "貸出ユーザを選択してください。"));
			mav.addObject("msg", msgList);
			mav.addObject("qrform", qrform);
			return mav;
		}

		try {
			boolean lendCheck = checkLendStatus(qrform);

			// 貸出状態とラジオボタンの選択で処理を決定
			if (lendCheck) {
				// 貸出処理
				System.out.println("貸出処理");
				lendService.kashidashi(qrform.getItemNumber(), qrform.getUser());
				msgList.add(new MessageBean(MessageBean.CAT_INFO, "貸出手続きが完了いたしました。備品番号:" + qrform.getItemNumber()));
			} else {
				System.out.println("貸出中です。");
				msgList.add(new MessageBean(MessageBean.CAT_INFO, "既に貸出されています。"));
				mav.addObject("qrform", qrform);
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

	/**
	 * 返却処理
	 * @param mav
	 * @param qrform
	 * @return
	 */
	@PostMapping("return")
	public ModelAndView postReturn(ModelAndView mav, LendQrForm qrform) {

		String result = "";
		List<MessageBean> msgList = new ArrayList<>();
		mav.setViewName("lendqr");

		if (!checkExistsUser(qrform)) {
			// ユーザの入力が無かった場合はそのまま画面を戻す
			msgList.add(new MessageBean(MessageBean.CAT_WARN, "貸出ユーザを選択してください。"));
			mav.addObject("msg", msgList);
			mav.addObject("qrform", qrform);
			return mav;
		}

		try {
			boolean lendCheck = checkLendStatus(qrform);
			// 貸出状態とラジオボタンの選択で処理を決定
			if (!lendCheck) {
				// 返却処理
				System.out.println("返却処理");
				lendService.henkyaku(qrform.getItemNumber(), qrform.getUser());
				msgList.add(new MessageBean(MessageBean.CAT_INFO, "返却手続きが完了いたしました。備品番号:" + qrform.getItemNumber()));
			} else {
				System.out.println("返却されています。");
				msgList.add(new MessageBean(MessageBean.CAT_INFO, "既に返却されています。"));
				mav.addObject("qrform", qrform);
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

	private boolean checkExistsUser(LendQrForm qrform) {
		boolean result = true;
		if (qrform.getUser().equals("")) {
			result = false;
		}
		return result;
	}

	/**
	 * 貸出状態チェック
	 * @param qrform
	 * @return
	 * @throws NotExistsItemException
	 */
	private boolean checkLendStatus(LendQrForm qrform) throws NotExistsItemException {
		// 貸出状態のチェック
		boolean lendCheck;
		lendCheck = lendService.lendCheck(qrform.getItemNumber());
		return lendCheck;
	}

}
