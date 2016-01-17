function addAccountInspector() {
	if(document.msform.name.value == "") {
		alert("이름을 입력하지 않았습니다.");
		document.msform.name.focus();
		return;
	}
	
	if (document.msform.name.value.indexOf(" ") >= 0) {
		 alert("이름에 공백을 사용할 수 없습니다.");
		 document.msform.name.focus();
		 document.msform.name.select();
		 return;
	}
	
	for(var i = 0; i < document.msform.name.value.length; i++) {
		var ch = document.msform.name.value.charAt(i);
		 if ((ch >= '0' && ch <= '9')) {
			  alert ("이름에는 숫자가 포함될수 없습니다.");
			  document.msform.name.focus();
			  document.msform.name.select();
			  return;
		 }
	}
	
	if(document.msform.id.value == "") {
		alert("아이디를 입력하지 않았습니다.");
		document.msform.id.focus();
		return;
	}
	
	for(var i = 0; i < document.msform.id.value.length; i++) {
		var ch = document.msform.id.value.charAt(i);
		 if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')) {
			  alert ("아이디는 소문자, 숫자만 입력가능합니다.");
			  document.msform.id.focus();
			  document.msform.id.select();
			  return;
		 }
	}
	
	if (document.msform.id.value.indexOf(" ") >= 0) {
		 alert("아이디에 공백을 사용할 수 없습니다.");
		 document.msform.id.focus();
		 document.msform.id.select();
		 return;
	}
	
	if (document.msform.id.value.length < 6 || 
		document.msform.id.value.length > 12) {
		 alert ("아이디를 6~12자까지 입력해주세요.");
		 document.msform.id.focus();
		 document.msform.id.select();
		 return;
	}
	
	if(document.msform.pass.value == "") {
		 alert("비밀번호를 입력하지 않았습니다.");
		 document.msform.pass.focus();
		 return;
	}
	//비밀번호 길이 체크(4~8자 까지 허용)
	if (document.msform.pass.value.length < 4 || 
		document.msform.pass.value.length > 8) {
		 alert ("비밀번호를 4~8자까지 입력해주세요.")
		 document.msform.pass.focus()
		 document.msform.pass.select()
		 return
	}
	
	//비밀번호와 비밀번호 확인 일치여부 체크
	if (document.msform.pass.value!=document.msform.cpass.value) {
		alert("입력한 두개의 비밀번호가 일치하지 않습니다");
		 document.msform.pass.value = "";
		 document.msform.cpass.value = "";
		 document.msform.pass.focus();
		 return;
	}
	
	var birth = document.msform.birth.value.split("-");
	
	for(var j = 0; j < 3; j++) {
		for(var i = 0; i < birth[j].length; i++) {
			var ch = birth[j].charAt(i);
			if (!(ch >= '0' && ch <= '9')) {
				alert ("생년월일을 정확히 입력하세요");		
				document.msform.birth.focus();
				document.msform.birth.select();
				return;
			}
		}
	}
	
	if(birth.length != 3 || 
	   birth[0].length != 4 || 
	   birth[1].length != 2 || 
	   birth[2].length != 2) {
		alert("생년월일을 정확히 입력하세요");
		document.msform.birth.focus();
		document.msform.birth.select();
		return;
	}
	var email = document.msform.email.value.split("@");
	
	if(email.length != 2) {
		alert("이메일을 정확히 입력하세요");
		document.msform.email.focus();
		document.msform.email.select();
		return;
	}
	
	var phone = document.msform.phone.value.split("-");
	if(phone[0].length != 3 ||
	   phone[1].length < 3 ||
	   phone[2].length != 4) {
		alert("휴대전화 번호를 정확히 입력하세요");
		document.msform.phone.focus();
		document.msform.phone.select();
		return;
	}
	
	for(var j = 0; j < 3; j++) {
		for(var i = 0; i < phone[j].length; i++) {
			var ch = phone[j].charAt(i);
			if (!(ch >= '0' && ch <= '9')) {
				alert ("휴대전화 번호를 정확히 입력하세요");		
				document.msform.phone.focus();
				document.msform.phone.select();
				return;
			}
		}
	}	
	document.msform.submit();
}

function updateAccountInspector() {
	if(document.msform.pass.value == "") {
		 alert("비밀번호를 입력하지 않았습니다.");
		 document.msform.pass.focus();
		 return;
	}
	//비밀번호 길이 체크(4~8자 까지 허용)
	if (document.msform.pass.value.length < 4 || 
		document.msform.pass.value.length > 8) {
		 alert ("비밀번호를 4~8자까지 입력해주세요.")
		 document.msform.pass.focus()
		 document.msform.pass.select()
		 return
	}
	
	//비밀번호와 비밀번호 확인 일치여부 체크
	if (document.msform.pass.value!=document.msform.cpass.value) {
		alert("입력한 두개의 비밀번호가 일치하지 않습니다");
		 document.msform.pass.value = "";
		 document.msform.cpass.value = "";
		 document.msform.pass.focus();
		 return;
	}
	
	var phone = document.msform.phone.value.split("-");
	if(phone[0].length != 3 ||
	   phone[1].length < 3 ||
	   phone[2].length != 4) {
		alert("휴대전화 번호를 정확히 입력하세요");
		document.msform.phone.focus();
		document.msform.phone.select();
		return;
	}
	
	document.msform.submit();
}

function updateRightInspector() {
	if(document.msform.classNo.value == "") {
		alert("기수 번호를 입력해 주세요~");
		document.msform.classNo.focus();
		return;
	}
	
	for(var i = 0; i < document.msform.classNo.value.length; i++) {
		var ch = document.msform.classNo.value.charAt(i);
		 if (!(ch >= '0' && ch <= '9')) {
			  alert("숫자만 입력가능합니다.");
			  document.msform.classNo.focus();
			  document.msform.classNo.select();
			  return;
		 }
	}
	document.msform.submit();
}