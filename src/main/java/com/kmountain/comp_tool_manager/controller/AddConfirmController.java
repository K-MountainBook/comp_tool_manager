package com.kmountain.comp_tool_manager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmountain.comp_tool_manager.entity.LendStatus;
import com.kmountain.comp_tool_manager.entity.NumberingMaster;
import com.kmountain.comp_tool_manager.entity.Specification;
import com.kmountain.comp_tool_manager.entity.Tools;
import com.kmountain.comp_tool_manager.form.AddForm;
import com.kmountain.comp_tool_manager.service.CategoryService;
import com.kmountain.comp_tool_manager.service.LendService;
import com.kmountain.comp_tool_manager.service.LendStatusService;
import com.kmountain.comp_tool_manager.service.NumberingMasterService;
import com.kmountain.comp_tool_manager.service.SpecificationService;

/**
 * 備品追加確認コントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("addconfirm")
public class AddConfirmController {

	private final LendService lendService;

	private final LendStatusService lendStatusService;

	private final SpecificationService specificationService;

	private final NumberingMasterService numberingMasterService;

	@Autowired
	public AddConfirmController(LendService lendService, LendStatusService lendStatusService,
			CategoryService categoryService, SpecificationService specificationService,
			NumberingMasterService numberingMasterService) {
		this.lendService = lendService;
		this.lendStatusService = lendStatusService;
		this.specificationService = specificationService;
		this.numberingMasterService = numberingMasterService;
	}

	/**
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mav, AddForm form) {

		// 新規登録なので未貸し出しの状態のステータスをリテラルで取得。
		LendStatus lendStatus = lendStatusService.getStatus(LendStatus.CODE_0);
		Specification specification = new Specification();

		Tools tools = new Tools();

		// 備品があればそのまま、無ければ登録を行う。
		Optional<Specification> specSearch = specificationService.findById(form.getSpecification());
		if (specSearch.isEmpty()) {
			// 無い場合は型番の登録を行う
			Specification specResult = specificationService.addSpecification(form.getSpecification());
			if (specResult == null) {
				// TODO nullになるはずはないので例外処理を行う
			}
			//無い場合は型番だけセット
			specification.setProductId(form.getSpecification());
			specification.setCommonInfo("");
		} else {
			// ある場合は抽出した値を一応セットする。
			specification.setProductId(specSearch.get().getProductId());
			specification.setCommonInfo(specSearch.get().getCommonInfo());
		}

		// 入力されたspecificationをインスタンスに格納する。

		// データ更新のためにtoolsのインスタンスに値をセットする
		tools.setLendId(form.getLendId());
		tools.setCategory(form.getCategory());
		tools.setMaker(form.getMaker());
		tools.setSpecification(specification);
		tools.setManagementName(form.getManagementName());
		tools.setAnotherInfo(form.getAnotherInfo());
		tools.setKeepPlace(form.getKeepPlace());
		tools.setLendTo("");
		tools.setRemarks(form.getRemarks());
		tools.setLendStatus(lendStatus);

		if (lendService.register(tools)) {
			// trueの場合は正常終了
			// categoryテーブルの数字を1足して終わり。
			Byte catByteType = form.getCategory().byteValue();
			NumberingMaster catUpdateData = numberingMasterService.getNumber(catByteType);
			catUpdateData.setNumber((short) (catUpdateData.getNumber() + 1));
			NumberingMaster catUpdateResult = numberingMasterService.save(catUpdateData);

			if (catUpdateResult == null) {
				// TODO nullだったらエラーです。
			}

		} else {
			// falseの場合はJPAのsave()メソッドから値が戻ってきてないので登録ミス
			// TODO 例外を出力する。
		}

		mav.addObject("registerdItem", tools);
		mav.setViewName("registered");

		return mav;
	}

}
