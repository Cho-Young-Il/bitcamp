function registBoardInspector() {
	if(document.rform.title.value == "") {
		alert("제목을 입력하지 않았습니다.");
		document.rform.title.focus();
		return;
	}
	if(document.rform.writer.value == "") {
		alert("이름을 입력하지 않았습니다.");
		document.rform.content.focus();
		return;
	}
	if(document.rform.content.value == "") {
		alert("내용을 입력하지 않았습니다.");
		document.rform.content.focus();
		return;
	}
	document.rform.submit();
}

function commentInspector() {
	if(document.cform.content.value == "") {
		alert("댓글 내용을 입력하지 않았습니다.");
		document.cform.content.focus();
		return;
	}
	document.cform.submit();
}