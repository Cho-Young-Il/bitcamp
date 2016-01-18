function mlec(val) {
	// val에 값이 입력되지 않은 경우
	if (!val) return ;
	
	// val : #title
	// val : .title
	// val : title
	
	var elements;
	
	var ch = val.charAt(0);
	switch (ch) {
	case "#":
		elements = document.querySelector(val);
		break;
	case "<":
		elements = document.createElement(
					val.substring(1, val.length - 1));
		break;
	default :
		elements = document.querySelectorAll(val);
	}
	
	/**
	 *  매개변수 html 에 값이 존재한다면 elements에 설정한다.
	 *  값이 존재하지 않다면 elements의 innerHTML 값을 넘겨준다.
	 *  
	 *  elements 여러개의 요소를 가지고 있다면 elements[0]에 적용
	 */
	elements.html = function(html) {
		// elements의 요소가 여러개인지 판단
		// elements의 요소가 하나라면 length는 undefined 가 된다.
		if (this.length) {
			// elements 의 0번째 요소에 처리
			// 값이 입력된 경우
			if (html) {
				this[0].innerHTML = html;
				return this;
			}
			// 값이 입력되지 않은 경우
			return this[0].innerHTML;
		}
		// elements의 요소가 하나인 경우
		else {
			if (html) {
				this.innerHTML = html;
				return this;
			}
			// 값이 입력되지 않은 경우
			return this.innerHTML;
		}
	};
	elements.text = function(text) {
		if (this.length) {
			if (text) {
				this[0].textContent = text;
				return this;
			}
			return this[0].textContent;
		}
		else {
			if (text) {
				this.textContent = text;
				return this;
			}
			return this.textContent;
		}
	};
	elements.css = function(name, val) {
		if (this.length) {
			if (val) {
				this[0].style[name] = val;
				return this;
			}
			return this[0].style[name];
		}
		else {
			if (val) {
				this.style[name] = val;
				return this;
			}
			return this.style[name];
		}
	};
	elements.attr = function(name, val) {
		if (this.length) {
			if (val) {
				this[0].setAttribute(name, val);
				return this;
			}
			return this[0].getAttribute(name);
		}
		else {
			if (val) {
				this.setAttribute(name, val);
				return this;
			}
			return this.getAttribute(name);
		}
	};
	elements.val = function(val) {
		if (this.length) {
			if (val != undefined) {
				this[0].value = val;
				return this;
			}
			return this[0].value;
		}
		else {
			if (val != undefined) {
				this.value = val;
				return this;
			}
			return this.value;
		}
	};
	elements.append = function(element) {
		if (this.length) {
			this[0].appendChild(element);
			return this;
		}
		else {
			this.appendChild(element);
			return this;
		}
	};
	elements.on = function(type, listener) {
		if (this.length) {
			this[0].addEventListener(type, listener);
			return this;
		}
		else {
			this.addEventListener(type, listener);
			return this;
		}
	};
	elements.click = function(listener) {
		if (this.length) {
			this[0].addEventListener("click", listener);
			return this;
		}
		else {
			this.addEventListener("click", listener);
			return this;
		}
	};
	return elements;
}

var $ = mlec;