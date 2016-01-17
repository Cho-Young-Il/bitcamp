function sendMsgInspector() {
	if(document.msform.content.value == "") {
		alert("쪽지 내용을 입력하지 않았습니다.");
		document.msform.content.focus();
		return;
	}
	document.msform.submit();
}