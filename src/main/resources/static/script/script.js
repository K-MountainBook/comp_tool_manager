
// 大分類から属する中分類を取得する
function getSubCategory(code) {
	var httpRequest = new XMLHttpRequest();
	// RESTfulAPIのアドレスを外に出したい
	httpRequest.open('GET', 'http://localhost:8080/api/v1/subcategory/' + code);
	httpRequest.send();

	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			console.log(httpRequest.responseText);
		}
	}
}

// 大分類から属する中分類を取得する
function getSub2Category(subcode, subsubcode) {
	var httpRequest = new XMLHttpRequest();
	// RESTfulAPIのアドレスを外に出したい
	httpRequest.open('GET', 'http://localhost:8080/api/v1/subcategory/' + subcode + "/" + subsubcode);
	httpRequest.send();

	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			console.log(httpRequest.responseText);
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

function showModal() {

}