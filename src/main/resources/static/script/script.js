
// 大分類から属する中分類を取得する
function getSubCategory(code) {
	var httpRequest = new XMLHttpRequest();

	// RESTfulAPIのアドレスを外に出したい
	httpRequest.open('GET', 'http://localhost:8080/api/v1/subcategory/' + code);
	httpRequest.send();

	httpRequest.onreadystatechange = () => {
		var jsonResult;
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			jsonResult = httpRequest.responseText;
			console.log(jsonResult);
			// objectを取得
			// selectのフォームを取得
			var select_form = document.getElementById('subCategory');
			// そのフォームの内容を取得。NodeListとかわからんちん。
			var options = document.querySelectorAll('#subCategory option');
			// 全てのオプションを一回削除
			removeAll(options);
			// 再度オプションの内容の作成
			select_form.appendChild(createOptionItem('選択してください', '0'));
			for (jsonItem of JSON.parse(jsonResult)) {
				console.log(jsonItem);
				select_form.appendChild(createOptionItem(jsonItem.subCatName, jsonItem.subCatNumber));
			}

		}
	}
}

// 大分類・中分類から属する小分類を取得する
function getSub2Category(subcode, subsubcode) {
	var httpRequest = new XMLHttpRequest();
	// RESTfulAPIのアドレスを外に出したい
	httpRequest.open('GET', 'http://localhost:8080/api/v1/subcategory/' + subcode + "/" + subsubcode);
	httpRequest.send();

	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			var jsonResult = httpRequest.responseText;
			console.log(jsonResult);
			// objectを取得
			// selectのフォームを取得
			var select_form = document.getElementById('sSubCategory');
			// そのフォームの内容を取得。NodeListとかわからんちん。
			var options = document.querySelectorAll('#sSubCategory option');
			// 全てのオプションを一回削除
			removeAll(options);
			// 再度オプションの内容の作成
			select_form.appendChild(createOptionItem('選択してください', '0'));
			for (jsonItem of JSON.parse(jsonResult)) {
				console.log(jsonItem);
				select_form.appendChild(createOptionItem(jsonItem.ssubCatName, jsonItem.ssubCatNumber));
			}
		}
	}
}

// カテゴリコードから現在の未使用の備品番号を取得する
function getManageNumber(code) {
	var httpRequest = new XMLHttpRequest();
	// RESTfulAPIのアドレスを外に出したい
	httpRequest.open('GET', 'http://localhost:8080/api/v1/numbering/' + code);
	httpRequest.send();

	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			console.log(httpRequest.responseText);
			document.getElementById('lendId').value = httpRequest.responseText;
		}
	}
}

function disableEnter(e) {
	if (e.keyCode === 13) {
		e.preventDefault();
	}
}


function removeAll(selectform) {
	selectform.forEach(o => o.remove());
}

function createOptionItem(text, value) {
	var option = document.createElement("option");
	option.text = text;
	option.value = value;
	return option;
}


function showModal() {

}