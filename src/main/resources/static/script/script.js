// カテゴリコードから現在の未使用の備品番号を取得する
function getManageNumber(code) {
	var httpRequest = new XMLHttpRequest();
	// RESTfulAPIのアドレスを外に出したい
	httpRequest.open('GET', 'http://localhost:8080/api/v1/numbering/' + code);
	httpRequest.send();

	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			document.getElementById('lendId').value = httpRequest.responseText;
		}
	}
}
