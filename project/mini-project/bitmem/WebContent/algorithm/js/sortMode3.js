var ctx;
var wcanvas = 850;
var hcanvas = 650;
var width = 3;
var height = 1.5;
var xcoordi = 16;
var ycoordi = 50;
var margin = 1;
var rect = [];
var rectBubble = [];
var rectInsert = [];
var rectQuick = [];
var rectShell = [];
var rectHeap = [];
var basicColor = "rgb(0, 0,0)";
var stop = 1;
var first = 0;
var i;
var ran = [];
var ranBubble = [];
var ranInsert = [];
var ranQuick = [];
var ranShell = [];
var ranHeap = [];
var freq = [];
var heapTmp = [];
var initflag = 0;
for (i = 0; i < 100; i++) {
	ran[i] = 100 - i;
	ranBubble[i] = 100 - i;
	ranInsert[i] = 100 - i;
	ranQuick[i] = 100 - i;
	ranShell[i] = 100 - i;
	heapTmp[i] = 100 - i;
}

ranLen = ran.length;

var check = true;

var leftx, rightx;
var leftIndex, rightIndex;
var swapA = [];
var swapB = [];
var swapC = [];
var swapD = [];
var swapMode = [];
var mode = -1;
var color = Math.round(Math.random() * 0xFFFFFF).toString(16);

var cnt = 0;
var timer;
var isStart = 0;
var speed = 1;
var flag = 0;
var num = 0;

var nodeTmp = [];
var nodeNum = [];
var selectnum1 = 1, selectnum2 = 3;

var swapA1 = [];
var swapB1 = [];
var swapC1 = [];
var swapD1 = [];
var swapMode1 = [];
var cnt1 = 0;
var timer1;
var num1 = 0;
var leftx1, rightx1;
var leftIndex1, rightIndex1;

var timer2;
var num2 = 0;
var cnt2 = 0;
var swapA2 = [];
var swapB2 = [];
var swapC2 = [];
var swapD2 = [];
var swapMode2 = [];
var leftx2, rightx2;
var leftIndex2, rightIndex2;

var timer3;
var num3 = 0;
var cnt3 = 0;
var swapA3 = [];
var swapB3 = [];
var swapC3 = [];
var swapD3 = [];
var swapMode3 = [];
var leftx3, rightx3;
var leftIndex3, rightIndex3;

var timer4;
var num4 = 0;
var cnt4 = 0;
var swapA4 = [];
var swapB4 = [];
var swapMode4 = [];
var leftx4, rightx4;
var leftIndex4, rightIndex4;

var timer5;
var num5 = 0;
var cnt5 = 0;
var swapA5 = [];
var swapB5 = [];
var swapC5 = [];
var swapD5 = [];
var swapMode5 = [];
var leftx5, rightx5;
var leftIndex5, rightIndex5;

var isStart1 = 0;
var isStart2 = 0;
var isStart3 = 0;
var isStart4 = 0;
var isStart5 = 0;
var isStart6 = 0;

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

function random() {
	var i;

	for (i = 0; i < 110; i++) {
		freq[i] = 0;
	}

	for (i = 0; i < 100; i++) {
		ran[i] = Math.floor(Math.random() * 100) + 1;
		if (freq[ran[i]] > 0 || ran[i] == 0) {
			i--;
			continue;
		}
		freq[ran[i]] = 1;
		ranBubble[i] = ran[i];
		ranInsert[i] = ran[i];
		ranQuick[i] = ran[i];
		ranShell[i] = ran[i];
		ranHeap[i] = ran[i];
		heapTmp[i] = ran[i];
		rect[i].sheight = (ran[i] * height);
		rectBubble[i].sheight = (ran[i] * height);
		rectInsert[i].sheight = (ran[i] * height);
		rectQuick[i].sheight = (ran[i] * height);
		rectShell[i].sheight = (ran[i] * height);
		rectHeap[i].sheight = (ran[i] * height);
	}
}

function Rectangle(num, sx, sy, swidth, sheight, stylestring) {
	this.num = num;
	this.sx = sx;
	this.sy = sy;
	this.swidth = swidth;
	this.sheight = sheight;
	this.fillstyle = stylestring;
	this.draw = drawRects;
}

function Rectangle1(num, sx, sy, swidth, sheight, stylestring) {
	this.num = num;
	this.sx = sx;
	this.sy = sy;
	this.swidth = swidth;
	this.sheight = sheight;
	this.fillstyle = stylestring;
	this.draw = drawRects1;
}

function Rectangle2(num, sx, sy, swidth, sheight, stylestring) {
	this.num = num;
	this.sx = sx;
	this.sy = sy;
	this.swidth = swidth;
	this.sheight = sheight;
	this.fillstyle = stylestring;
	this.draw = drawRects2;
}

function Rectangle3(num, sx, sy, swidth, sheight, stylestring) {
	this.num = num;
	this.sx = sx;
	this.sy = sy;
	this.swidth = swidth;
	this.sheight = sheight;
	this.fillstyle = stylestring;
	this.draw = drawRects3;
}

function Rectangle4(num, sx, sy, swidth, sheight, stylestring) {
	this.num = num;
	this.sx = sx;
	this.sy = sy;
	this.swidth = swidth;
	this.sheight = sheight;
	this.fillstyle = stylestring;
	this.draw = drawRects4;
}

function Rectangle5(num, sx, sy, swidth, sheight, stylestring) {
	this.num = num;
	this.sx = sx;
	this.sy = sy;
	this.swidth = swidth;
	this.sheight = sheight;
	this.fillstyle = stylestring;
	this.draw = drawRects5;
}

function drawRects(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx + 20, this.sy + 480, this.swidth, -this.sheight);
	ctx.fillStyle = "rgb(255, 102, 0)";
}

function drawRects1(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx + 450, this.sy + 480, this.swidth, -this.sheight);
	ctx.fillStyle = "rgb(255, 102, 0)";
}

function drawRects2(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx + 20, this.sy + 280, this.swidth, -this.sheight);
	ctx.fillStyle = "rgb(255, 102, 0)";
}

function drawRects3(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx + 450, this.sy + 280, this.swidth, -this.sheight);
	ctx.fillStyle = "rgb(255, 102, 0)";
}

function drawRects4(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx + 450, this.sy + 80, this.swidth, -this.sheight);
	ctx.fillStyle = "rgb(255, 102, 0)";
}

function drawRects5(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx + 20, this.sy + 80, this.swidth, -this.sheight);
	ctx.fillStyle = "rgb(255, 102, 0)";
}

for (i = 0; i < ranLen + 1; i++) {
	var tmp = new Rectangle(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	var tmp1 = new Rectangle1(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	var tmp2 = new Rectangle2(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	var tmp3 = new Rectangle3(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	var tmp4 = new Rectangle4(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	var tmp5 = new Rectangle5(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	xcoordi = xcoordi + width + margin;
	rect.push(tmp);
	rectBubble.push(tmp1);
	rectInsert.push(tmp2);
	rectQuick.push(tmp3);
	rectShell.push(tmp4);
	rectHeap.push(tmp5);
}

function init() {
	isStart1 = 0;
	isStart2 = 0;
	isStart3 = 0;
	isStart4 = 0;
	isStart5 = 0;
	isStart6 = 0;
	xcoordi = 280 - ranLen * (width) + 10;
	ycoordi = 140;
	random();
	stop = 0;

	for (i = 0; i < ranLen; i++) {
		rect[i].sx = xcoordi;
		rect[i].sy = ycoordi;
		rectBubble[i].sx = xcoordi;
		rectBubble[i].sy = ycoordi;
		rectInsert[i].sx = xcoordi;
		rectInsert[i].sy = ycoordi;
		rectQuick[i].sx = xcoordi;
		rectQuick[i].sy = ycoordi;
		rectShell[i].sx = xcoordi;
		rectShell[i].sy = ycoordi;
		rectHeap[i].sx = xcoordi;
		rectHeap[i].sy = ycoordi;

		xcoordi = xcoordi + width + margin;
	}
	ctx = document.getElementById('myCanvas').getContext('2d');

	displayTime();
	initdrawall();

	for (var reset = 0; reset < 10000; reset++) {
		swapA[reset] = 0;
		swapB[reset] = 0;
		swapC[reset] = 0;
		swapD[reset] = 0;
		swapMode[reset] = 0;
		cnt = 0;
		num = 0;
		swapA1[reset] = 0;
		swapB1[reset] = 0;
		swapC1[reset] = 0;
		swapD1[reset] = 0;
		swapMode1[reset] = 0;
		cnt1 = 0;
		num1 = 0;
		swapA2[reset] = 0;
		swapB2[reset] = 0;
		swapC2[reset] = 0;
		swapD2[reset] = 0;
		swapMode2[reset] = 0;
		cnt2 = 0;
		num2 = 0;
		swapA3[reset] = 0;
		swapB3[reset] = 0;
		swapC3[reset] = 0;
		swapD3[reset] = 0;
		swapMode3[reset] = 0;
		cnt3 = 0;
		num3 = 0;
		swapA4[reset] = 0;
		swapB4[reset] = 0;
		swapMode4[reset] = 0;
		cnt4 = 0;
		num4 = 0;
		swapA5[reset] = 0;
		swapB5[reset] = 0;
		swapC5[reset] = 0;
		swapD5[reset] = 0;
		swapMode5[reset] = 0;
		cnt5 = 0;
		num5 = 0;

	}
}

function drawAll() {
	ctx.clearRect(0, 0, 5000, 5000);
	drawLine();
	var j;
	for (j = 0; j < rect.length; j++) {
		rect[j].draw(basicColor);
		rectBubble[j].draw(basicColor);
		rectInsert[j].draw(basicColor);
		rectQuick[j].draw(basicColor);
		rectShell[j].draw(basicColor);
		rectHeap[j].draw(basicColor);
	}
}

function initdrawall() {
	for (j = 0; j < rect.length; j++) {
		rect[j].fillstyle = basicColor;
		rectBubble[j].fillstyle = basicColor;
		rectInsert[j].fillstyle = basicColor;
		rectQuick[j].fillstyle = basicColor;
		rectShell[j].fillstyle = basicColor;
		rectHeap[j].fillstyle = basicColor;
	}
	drawAll();
}

function stopAnimation() {
	clearInterval(timer);
	clearInterval(timer1);
	clearInterval(timer2);
	clearInterval(timer3);
	clearInterval(timer4);
	clearInterval(timer5);
	stop = 1;
}

function started() {
	if (isStart1 == 1 || isStart2 == 1 || isStart3 == 1 || isStart4 == 1
			|| isStart5 == 1 || isStart6 == 1) {
		return true;
	} else
		return false;

}

function bubbleSort() {
	isStart1 = 1;
	cnt = 0;
	num = 0;
	var i = 0;
	var j = 0;
	var length = ran.length;
	while (i++ < length - 1) {

		for (j = 0; j < length - i; j++) {
			a = ran[j];
			b = ran[j + 1];

			swapC[cnt] = j;
			swapD[cnt] = j + 1;

			if ((a - b) > 0) {
				leftx = rect[j].sx;
				rightx = rect[j + 1].sx;

				leftIndex = j;
				rightIndex = j + 1;
				swapA[cnt] = leftIndex;
				swapB[cnt] = rightIndex;
				swapMode[cnt] = 1;

				ran[j] = b;
				ran[j + 1] = a;
			}
			if (j == length - i)
				swapC[cnt] = 1;
			cnt++;
		}
	}
	num = 0;
	cnt++;
}

function SwapAnimationBubble() {

	if (cnt < num) {
		drawAll();
		return;
	}
	leftIndex = swapA[num];
	rightIndex = swapB[num];

	heightSwapBubble(leftIndex, rightIndex);
	num++;
	drawAll();
}
function bubbleAnimation() {
	if (swapMode[num] == 1)
		SwapAnimationBubble();
	else
		num++;

	if (cnt < num) {
		isStart1 = 0;
		initdrawall();
		isStart--;
		clearInterval(timer);
		console.log(isStart);
	}
}

function SwapAnimationInsert() {

	if (cnt2 < num2) {
		drawAll();
		return;
	}
	leftIndex2 = swapA2[num2];
	rightIndex2 = swapB2[num2];

	heightSwapInsert(leftIndex2, rightIndex2);
	num2++;
	drawAll();
}

function SwapAnimationQuick() {

	if (cnt3 < num3) {
		drawAll();
		return;
	}
	leftIndex3 = swapA3[num3];
	rightIndex3 = swapB3[num3];

	heightSwapQuick(leftIndex3, rightIndex3);
	num3++;
	drawAll();
}

function SwapAnimationHeap() {

	if (cnt5 < num5) {
		drawAll();
		return;
	}
	leftIndex5 = swapA5[num5];
	rightIndex5 = swapB5[num5];

	heightSwapHeap(leftIndex5, rightIndex5);
	num5++;
	drawAll();
}

function startSort() {
	if (stop == 0) {
		first = 1;
		bubbleSort();
		selectionSort(ranBubble);
		insertionSort(ranInsert);
		quickSort(0, 100, 0);
		shellSort(ranShell);
		heapSort();
		timer = setInterval(bubbleAnimation, 1);
		timer1 = setInterval(selectionAnimation, 1);
		timer2 = setInterval(insertionAnimation, 1);
		timer3 = setInterval(quickSortAnimation, 1);
		timer4 = setInterval(shellSortAnimation, 1);
		timer5 = setInterval(heapAnimation, 1);
		stop = 1;
		isStart1 = 1;
		isStart2 = 1;
		isStart3 = 1;
		isStart4 = 1;
		isStart5 = 1;
		isStart6 = 1;
		console.log("qwd");
	} else if (stop == 1) {
		if (isStart1 == 0 && isStart2 == 0 && isStart3 == 0 && isStart4 == 0
				&& isStart5 == 0 && isStart6 == 0) {
			return;
		}
		timer = setInterval(bubbleAnimation, 1);
		timer1 = setInterval(selectionAnimation, 1);
		timer2 = setInterval(insertionAnimation, 1);
		timer3 = setInterval(quickSortAnimation, 1);
		timer4 = setInterval(shellSortAnimation, 1);
		timer5 = setInterval(heapAnimation, 1);

	}
}

function SwapAnimationSelection() {
	if (cnt1 < num1) {
		drawAll();
		return;
	}
	leftIndex1 = swapA1[num1];
	rightIndex1 = swapB1[num1];

	heightSwapSelection(leftIndex1, rightIndex1);
	num1++;

	drawAll();

}

function SwapAnimationShell() {
	if (cnt4 < num4) {
		drawAll();
		return;
	}
	leftIndex4 = swapA4[num4];
	rightIndex4 = swapB4[num4];

	heightSwapShell(leftIndex4, rightIndex4);
	num4++;

	drawAll();

}

function selectionAnimation() {
	if (swapMode1[num1] == 1) {
		SwapAnimationSelection();
	} else
		num1++;
	if (cnt1 < num1 - 1) {
		isStart2 = 0;
		clearInterval(timer1);
		timer1 = 0;
		return;
	}
}

function heightSwapBubble(i, j) {
	var tmp;
	tmp = rect[i].sheight;
	rect[i].sheight = rect[j].sheight;
	rect[j].sheight = tmp;
}

function heightSwapQuick(i, j) {
	var tmp;
	tmp = rectQuick[i].sheight;
	rectQuick[i].sheight = rectQuick[j].sheight;
	rectQuick[j].sheight = tmp;
}

function heightSwapShell(i, j) {
	var tmp;
	tmp = rectShell[i].sheight;
	rectShell[i].sheight = rectShell[j].sheight;
	rectShell[j].sheight = tmp;
}

function heightSwapInsert(i, j) {
	var tmp;
	tmp = rectInsert[i].sheight;
	rectInsert[i].sheight = rectInsert[j].sheight;
	rectInsert[j].sheight = tmp;
}

function heightSwapSelection(i, j) {
	var tmp1;
	tmp1 = rectBubble[i].sheight;
	rectBubble[i].sheight = rectBubble[j].sheight;
	rectBubble[j].sheight = tmp1;
}

function heightSwapHeap(i, j) {
	var tmp1;
	tmp1 = rectHeap[i].sheight;
	rectHeap[i].sheight = rectHeap[j].sheight;
	rectHeap[j].sheight = tmp1;
}

function insertionSort(arr) {
	isStart3 = 1;
	var i = 0, length = arr.length, j = 0, temp, itmp;

	for (i = 0; i < length; i++) {
		itmp = i;
		temp = arr[i];

		for (j = i - 1; j >= 0; j--) {
			if (arr[j] > temp) {
				leftx2 = rectInsert[j].sx;
				rightx2 = rectInsert[itmp].sx;
				leftIndex2 = j, rightIndex2 = itmp;

				swapA2[cnt2] = j;
				swapB2[cnt2] = itmp;
				swapMode2[cnt2] = 1;
				cnt2++;

				itmp = j;
				arr[j + 1] = arr[j];
			} else
				break;
		}
		arr[j + 1] = temp;
	}
}

function insertionAnimation() {
	if (swapMode2[num2] == 1) {
		SwapAnimationInsert();
	} else
		num2++;

	if (cnt2 < num2) {

		initdrawall();
		clearInterval(timer2);
		timer2 = 0;
		isStart3 = 0;

	}
}

function selectionSort(arr) {
	isStart2 = 1;
	var i = 0, length = arr.length, j = 0, t, min;
	cnt1 = 0;
	for (i = 0; i < length - 1; i++) {
		min = i;

		for (j = i + 1; j < length; j++) {

			if (arr[min] > arr[j]) {
				min = j;
			}

			if (j == length - 1) {
				SelectSortSwap(i, min);
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			} else {
				swapA1[cnt1] = 0;
				swapB1[cnt1] = 0;
				swapMode1[cnt1] = 15;
				cnt1++;
			}
		}

	}
}

function SelectSortSwap(i, j) {
	leftx1 = rectBubble[i].sx;
	rightx1 = rectBubble[j].sx;
	leftIndex1 = i, rightIndex1 = j;

	swapA1[cnt1] = leftIndex1;
	swapB1[cnt1] = rightIndex1;
	swapMode1[cnt1] = 1;
	cnt1++;
}

function partition(low, high) {
	var i, j;
	var tmp;
	var pivoitem = ranQuick[low];

	j = low;
	swapA3[cnt3] = low;
	swapB3[cnt3] = high;
	swapC3[cnt3] = 1;
	swapD3[cnt3] = 1;
	swapMode3[cnt3] = 6;
	cnt3++;

	for (i = low + 1; i <= high; i++) {
		if (ranQuick[i] < pivoitem) {
			j++;
			quickSortSwap(j, i);
			tmp = ranQuick[i];
			ranQuick[i] = ranQuick[j];
			ranQuick[j] = tmp;
		}
	}
	quickSortSwap(low, j);
	tmp = ranQuick[low];
	ranQuick[low] = ranQuick[j];
	ranQuick[j] = tmp;

	return j;
}

function quickSort(low, high, t) {
	isStart4 = 1;
	var pivoindex;
	if (low < high) {
		pivoindex = partition(low, high);
		quickSort(low, pivoindex - 1, t + 1);
		quickSort(pivoindex + 1, high, t + 1);
	}
}

function quickSortAnimation() {
	if (swapMode3[num3] == 5) {
		initdrawall();
	} else if (swapMode3[num3] == 4) {
		drawAll();
	} else if (swapMode3[num3] == 6) {
		num3++;
		drawAll();
	} else if (swapMode3[num3] == 7) {
		rectQuick[swapA3[num3]].draw();
	}

	if (swapMode3[num3] == 1) {
		SwapAnimationQuick();
	} else if (swapMode3[num3] == 2) {
		drawAll();
		SwapAnimationQuick();
	} else
		num3++;

	if (cnt3 < num3) {
		console.log(isStart);
		stop = 0;
		initdrawall();
		clearInterval(timer3);
		timer3 = 0;
		isStart4 = 0;
	}
}

function quickSortSwap(i, j) {
	leftx3 = rectQuick[i].sx;
	rightx3 = rectQuick[j].sx;
	leftIndex3 = i, rightIndex3 = j;

	swapA3[cnt3] = leftIndex3;
	swapB3[cnt3] = rightIndex3;
	swapMode3[cnt3] = 2;
	cnt3++;

}

function shellSort(arr) {
	isStart5 = 1;
	var i = 0, length = arr.length, j = 0, temp, gap;
	gap = 20;

	while (gap > 0) {
		for (i = 0; i < length; i++) {
			j = i;
			temp = arr[i];
			while (j >= gap && arr[j - gap] > temp) {
				leftx4 = rect[j - gap].sx;
				rightx4 = rect[j].sx;
				leftIndex4 = j - gap, rightIndex4 = j;

				swapA4[cnt4] = leftIndex4;
				swapB4[cnt4] = rightIndex4;
				swapMode4[cnt4] = 1;
				cnt4++;

				arr[j] = arr[j - gap];
				j = j - gap;

			}
			arr[j] = temp;
		}
		if (gap == 1)
			gap = 0;
		else if (gap % 2 != 0)
			gap = gap / 2 + 1;
		else
			gap = gap / 2;
	}

}

function shellSortAnimation() {
	if (swapMode4[num4] == 1) {
		SwapAnimationShell();
	} else
		num4++;

	if (cnt4 < num4 - 1) {
		stop = 0;
		clearInterval(timer4);
		initdrawall();
		timer4 = 0;
		isStart5 = 0;

	}
}

function heapSort() {
	isStart6 = 1;
	var i, temp;
	var arrayHalf;
	var array_size = ran.length;

	arrayHalf = Math.floor(array_size / 2);

	for (i = arrayHalf - 1; i >= 0; i--)
		siftDown(i, array_size);

	for (i = array_size - 1; i >= 1; i--) {
		heapSortAnimation(0, i);

		temp = ranHeap[0];
		ranHeap[0] = ranHeap[i];
		ranHeap[i] = temp;
		siftDown(0, i - 1);
	}
}

function siftDown(root, bottom) {
	var done, maxChild, temp;

	done = 0;
	while ((root * 2 <= bottom) && (!done)) {
		if (root * 2 == bottom)
			maxChild = root * 2;
		else if (ranHeap[root * 2] > ranHeap[root * 2 + 1])
			maxChild = root * 2;
		else
			maxChild = root * 2 + 1;

		if (ranHeap[root] < ranHeap[maxChild]) {
			heapSortAnimation(root, maxChild);

			temp = ranHeap[root];
			ranHeap[root] = ranHeap[maxChild];
			ranHeap[maxChild] = temp;
			root = maxChild;
		} else
			done = 1;
	}
}

function heapSortAnimation(i, j) {

	selectnum1 = i;
	selectnum2 = j;

	leftx5 = rectHeap[i].sx;
	rightx5 = rectHeap[j].sx;
	leftIndex5 = i, rightIndex5 = j;

	swapA5[cnt5] = leftIndex5;
	swapB5[cnt5] = rightIndex5;
	swapMode5[cnt5] = 1;
	cnt5++;

	selectnum1 = -1;
	selectnum2 = -1;

}

function heapAnimation() {
	if (swapMode5[num5] == 1) {
		SwapAnimationHeap();
	} else
		num5++;

	if (cnt5 < num5) {
		stop = 0;
		clearInterval(timer5);
		timer5 = 0;
		isStart6 = 0;

		return;
	}
}

function drawLine() {
	var ctxLine = document.getElementById('myCanvas').getContext('2d');
	var ctxNum = document.getElementById('myCanvas').getContext('2d');
	ctxNum.font = "bold 20px Lucida Handwriting";
	ctxLine.fillStyle = "rgb(0,0,0)";

	ctxLine.fillRect(0, 25, 2, 602);
	ctxLine.fillRect(425, 25, 2, 602);
	ctxLine.fillRect(850, 25, 2, 602);

	ctxLine.fillRect(0, 25, 850, 2);
	ctxLine.fillRect(0, 225, 850, 2);
	ctxLine.fillRect(0, 425, 850, 2);
	ctxLine.fillRect(0, 625, 850, 2);

	ctxNum.fillText("Heap Sort", 20, 50);
	ctxNum.fillText("Shell Sort", 450, 50);
	ctxNum.fillText("Insert Sort", 20, 250);
	ctxNum.fillText("Quick Sort", 450, 250);
	ctxNum.fillText("Bubble Sort", 20, 450);
	ctxNum.fillText("Selection Sort", 450, 450);
}
