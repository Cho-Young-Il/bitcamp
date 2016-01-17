var d, h, m, s, co;
function displayTime() {
	d = new Date();
	h = d.getHours();
	m = d.getMinutes();
	s = d.getSeconds();

	if (h <= 9)
		h = '0' + h;
	if (m <= 9)
		m = '0' + m;
	if (s <= 9)
		s = '0' + s;

	co = "#" + h + m + s;
	document.getElementById("hex").innerHTML = co;
	setTimeout(displayTime, 1000);
}
displayTime();