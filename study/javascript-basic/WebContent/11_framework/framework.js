function mlec(val) {
	//val에 값이 입력되지 않은경우
	if(!val) return;
	
	//val : #title
	//val : .title
	//val : title
	var ch = val.charAt(0);
	
	var elements;
	
	switch(ch) {
	case "#" :
		elements = document.querySelector(val);
		break;
	default :
		elements = document.querySelectorAll(val);
	}
	
	/*
	 * 매개변수 html에 값이 존재한다면 elements에 설정한다.
	 * 값이 존재하지 않으면 elements의 innerHTML값을 넘겨준다.
	 * 
	 * elements가 여러개 요소를 가지고 있다면 elements[0]에 적용
	 */
	elements.html = function(html) {
		// elements의 요소가 여러개인지 판단
		// elements의 요소가 하나라면 length는 undefined가 된다.
		if(elements.length) {
			//elements의 0번째 요소에 처리
			//값이 입력된 경우
			if(html) {
				this[0].innerHTML = html;
				return this;
			}
			//값이 입력되지 않은 경우
			return this[0].innerHTML;
		} else {
			//elements의 요소가 하나인 경우
			if(html) {
				this.innerHTML = html;
				return this;
			}
			return this.innerHTML;
		}
	};
	
	elements.text = function(html) {
		// elements의 요소가 여러개인지 판단
		// elements의 요소가 하나라면 length는 undefined가 된다.
		if(elements.length) {
			//elements의 0번째 요소에 처리
			//값이 입력된 경우
			if(text) {
				this[0].textContent = text;
				return this;
			}
			//값이 입력되지 않은 경우
			return this[0].textContent;
		} else {
			//elements의 요소가 하나인 경우
			if(text) {
				this.textContent = text;
				return this;
			}
			return this.textContent;
		}
	};
	
	elements.css = function(name, value) {
		if(elements.length) {
			if(val) {
				this[0].style[name] = value;
				return this;
			}
			return this[0].style[name];
		} else {
			if(val) {
				this.style[name] = value;
				return this;
			}
			return this.style[name];
		}
	};
	return elements;
	
	elements.val = function(param) {
		if(elements.length) {
			if(val) {
				this[0].style[name] = value;
				return this;
			}
			return this[0].style[name];
		} else {
			if(val) {
				this.style[name] = value;
				return this;
			}
			return this.style[name];
		}
	};
	return elements;
}

var $ = mlec;