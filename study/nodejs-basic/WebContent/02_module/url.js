/*
 * 	url : 정보를 분석
 */
var url = require("url");
console.log(url);

var urlObj = url.parse(
	"http://localhost:10001/list.do?id=hong"
);
console.log(urlObj);
console.log(urlObj.pathname);
console.log(urlObj.query);