<svg id="canvas" width="950 " height="400" style=" margin: 10px">
<g transform="translate(200, 200) scale(1, -1)">
	<rect id="background1" onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';" width="350" height="320" x = "-180" y="-150" style ="fill: white; stroke-width:4; stroke: black; stroke-opacity:0.9;"></rect>
	<rect id="rect1"  onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';"  width="40" height="100" x = "-100" y="-10" style ="fill: black"></rect>
	<animate
	xlink:href="#rect1"
	attributeName="height"
	from="10"
	to="150"
	dur="1s"
	begin="background1.mouseover"
	repeatCount="2"
	values="100;50;20;150;100"
	keyTimes="0;0.2;0.5;0.8;1"
	fill="freeze"
	d="rect1-anim" ></animate>
	<rect id="rect2"  onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';" width="40" height="100" x = "-50" y="-10" style ="fill: black"></rect>
	<animate
	xlink:href="#rect2"
	attributeName="height"
	from="10"
	to="150"
	dur="1s"
	begin="background1.mouseover"
	repeatCount="2"
	values="100;50;20;150;100"
	keyTimes="0;0.4;0.5;0.7;1"
	fill="freeze"
	d="rect2-anim" ></animate>
	<rect id="rect3"  onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';" width="40" height="100" x = "0" y="-10" style ="fill: black"></rect>
	<animate
	xlink:href="#rect3"
	attributeName="height"
	from="10"
	to="150"
	dur="1s"
	begin="background1.mouseover"
	repeatCount="2"
	values="100;50;20;150;100"
	keyTimes="0;0.5;0.7;0.8;1"
	fill="freeze"
	d="rect3-anim" ></animate>
	<rect id="rect4"  onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';" width="40" height="100" x = "50" y="-10" style ="fill: black"></rect>
	<animate
	xlink:href="#rect4"
	attributeName="height"
	from="10"
	to="150"
	dur="1s"
	begin="background1.mouseover"
	repeatCount="2"
	values="100;50;60;150;100"
	keyTimes="0;0.2;0.3;0.6;1"
	fill="freeze"
	d="rect4-anim" ></animate>

</g>
<text id="title" onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';" x="110" y="270" style ="fill: black; font-size :1.4em; opacity:1; font-family: 'Hanna', arial, verdana;">
	Sorting Algorithm
</text>
<text id="title2" onclick = "window.top.location.href='<%=request.getContextPath()%>/algorithm/sort';" x="135" y="310" style ="fill: black; font-size :1.4em; opacity:1; font-family: 'Hanna', arial, verdana;">
	 Visualization
</text>
<animate
xlink:href="#title"
attributeName="opacity"
from="0"
to="1"
dur="1s"
begin="background1.mouseover"
repeatCount="1"
values="0.1;0.4;1"
keyTimes="0;0.4;1"
fill="freeze"
d="title-anim" ></animate>
<animate
xlink:href="#title2"
attributeName="opacity"
from="0"
to="1"
dur="1s"
begin="background1.mouseover"
repeatCount="1"
values="0.1;0.4;1"
keyTimes="0;0.4;1"
fill="freeze"
d="title-anim" ></animate>

</svg>
