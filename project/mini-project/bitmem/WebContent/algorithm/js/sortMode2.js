var ctx;
var wcanvas = 950;
var hcanvas = 650;
var width = 5;
var height = 5;
var xcoordi = 16;
var ycoordi = 50;
var margin = 2;

var rect = [];
var basicColor = "#333333";
var stop = 0;
var i;
var ran = [];
var freq = [];

for (i = 0; i < 100; i++) {
	ran[i] = 100 - i;
}

ranLen = ran.length;

var leftx, rightx;
var leftIndex, rightIndex;
var check = true;

var swapA = [];
var swapB = [];
var swapC = [];
var swapD = [];
var mode = -1;
var swapMode = [];
var color = Math.round(Math.random() * 0xFFFFFF).toString(16);

var cnt = 0;
var timer;
var isStart = 0;
var speed = 1;
var flag = 0;
var num = 0;

var nodeTmp = [];
var nodeNum = [];
var heapTmp = [];
var selectnum1 = 1, selectnum2 = 3;
var menuNum = [];

var d, h, m, s, color;
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

	color = "#" + h + m + s;
	document.getElementById("hex").innerHTML = color;
	setTimeout(displayTime, 1000);
}

function menuToggle() {
	var i;
	for (i = 0; i < 7; i++) {
		if (i == 3 || i == 5)
			continue;
		menuNum[i] = document.getElementById('menu' + i.toString());
		menuNum[i].style.background = "white";
		if (mode == i) {
			menuNum[i].style.background = "#EAEAEA";
		}

	}
}

function random() {
	for (i = 0; i < 100; i++) {
		ran[i] = Math.round(Math.random() * 101);
		if (freq[ran[i] > 0] || ran[i] == 0) {
			i--;
			continue;
		}

		freq[ran[i]] = 1;

		rect[i].sheight = (ran[i] * height);
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

function drawRects(fillstyle) {
	ctx.fillStyle = this.fillstyle;
	ctx.fillRect(this.sx, this.sy + 500, this.swidth, -this.sheight);

}

for (i = 0; i < ranLen + 1; i++) {
	var tmp = new Rectangle(ran[i], xcoordi, ycoordi, width, height * ran[i],
			"rgb(0, 5, 90)");
	xcoordi = xcoordi + width + margin;
	rect.push(tmp);
}

function init() {
	displayTime();
	menuToggle();

	xcoordi = 630 - ranLen * (width);
	ycoordi = 50;
	for (i = 0; i < ranLen; i++) {
		rect[i].sx = xcoordi;
		rect[i].sy = ycoordi;
		xcoordi = xcoordi + width + margin;
	}
	ctx = document.getElementById('myCanvas').getContext('2d');

	random();
	initdrawall();

	for (var reset = 0; reset < 10000; reset++) {
		isStart = 0;
		stop = 0;
		swapA[reset] = 0;
		swapB[reset] = 0;
		swapC[reset] = 0;
		swapD[reset] = 0;
		swapMode[reset] = 0;
		cnt = 0;
		num = 0;
	}
}

function drawAll() {
	ctx.clearRect(0, 0, 1300, 650);

	var j;
	for (j = 0; j < rect.length; j++) {
		rect[j].draw(basicColor);
	}
}

function initdrawall() {
	for (j = 0; j < rect.length; j++) {
		rect[j].fillstyle = basicColor;
	}
	drawAll();
}

function changeValue() {
	ctx.clearRect(0, 0, 2000, 2000);

	var k;
	var count = 0;
	var inputError = false;

	xcoordi = 16;

	for (k = 0; k < ranLen; k++) {
		var tmp = new Rectangle(ran[k], xcoordi, ycoordi, width, height
				* ran[k], "rgb(0, 5, 90)");
		xcoordi = xcoordi + width + margin;
		rect.push(tmp);
	}

	init();

	for (var reset = 0; reset < 20000; reset++) {
		isStart = 0;
		stop = 0;
		swapA[reset] = 0;
		swapB[reset] = 0;
		swapC[reset] = 0;
		swapD[reset] = 0;
		swapMode[reset] = 0;
	}

	return false;
}

function stopAnimation() {
	clearInterval(timer);
	stop = 1;
}

function restartAnimation() {
	if (isStart == 0) {
		stop = 0;
		num = 0;
		cnt = 0;

		if (mode == 0)
			bubbleSort();
		else if (mode == 1)
			insertionSort(ran);
		else if (mode == 2)
			shellSort(ran);
		else if (mode == 3) {
			mergeSort(ran, 0, ran.length - 1);
			mergeSortStart();
		} else if (mode == 4)
			selectionSort(ran);
		else if (mode == 5) {
			var k;

			for (k = 0; k < ran.length; k++) {
				heapTmp[k] = ran[k];
			}
			heapSort();
			heapStart();
		} else if (mode == 6) {
			quickSort(0, ran.length - 1, 0);
			startQuick();
		}

		if (mode >= 0 && mode <= 6)
			isStart = 1;
	} else if (isStart == 1 && stop == 1) {
		if (mode == 0)
			timer = setInterval(bubbleAnimation, 1);
		else if (mode == 1)
			timer = setInterval(insertionAnimation, 1);
		else if (mode == 2)
			timer = setInterval(shellSortAnimation, 1);
		else if (mode == 3)
			timer = setInterval(mergeSortAnimation, 1);
		else if (mode == 4)
			timer = setInterval(selectionAnimation, 1);
		else if (mode == 5)
			timer = setInterval(heapAnimation, 1);
		else if (mode == 6)
			timer = setInterval(quickSortAnimation, 1);
		stop = 0;
	}

}

function numSwap(i, j) {
	var tmp;
	tmp = rect[i].num;
	rect[i].num = rect[j].num;
	rect[j].num = tmp;
}

function bubbleSort() {
	isStart = 1;
	cnt = 0;
	num = 0;
	var i = 0;
	var j = 0;
	var length = ran.length;
	while (i++ < length - 1) {
		for (j = 0; j < length - 1; j++) {
			a = ran[j];
			b = ran[j + 1];

			if ((a - b) > 0) {
				check = true;
				leftx = rect[j].sx;
				rightx = rect[j + 1].sx;

				leftIndex = j;
				rightIndex = j + 1;
				swapA[cnt] = leftIndex;
				swapB[cnt] = rightIndex;
				swapMode[cnt] = 1;
				cnt++;
				ran[j] = b;
				ran[j + 1] = a;
			}
		}
	}
	num = 0;
	cnt++;
	timer = setInterval(bubbleAnimation, 1);
}

function SwapAnimation() {
	if (cnt < num) {
		drawAll();
		isStart = 0;
		stop = 0;
		clearInterval(timer);
		timer = 0;
		return;
	}
	leftIndex = swapA[num];
	rightIndex = swapB[num];

	var left = 0, right = 0;

	left = leftIndex;
	right = rightIndex;

	leftx = rect[swapA[num]].sx;
	rightx = rect[swapB[num]].sx;

	rect[leftIndex].sx = leftx;
	rect[rightIndex].sx = rightx;
	heightSwap(leftIndex, rightIndex);
	check = false;
	num++;

	rect[leftIndex].fillstyle = "lightgreen";
	rect[rightIndex].fillstyle = "lightgreen";
	drawAll();

	rect[leftIndex].fillstyle = basicColor;
	rect[rightIndex].fillstyle = basicColor;
}

function heightSwap(i, j) {
	var tmp;
	tmp = rect[i].sheight;
	rect[i].sheight = rect[j].sheight;
	rect[j].sheight = tmp;
}

function insertionSort(arr) {

	var i = 0, length = arr.length, j = 0, temp, itmp;

	for (i = 0; i < length; i++) {
		itmp = i;
		temp = arr[i];

		for (j = i - 1; j >= 0; j--) {
			if (arr[j] > temp) {
				leftx = rect[j].sx;
				rightx = rect[itmp].sx;
				leftIndex = j, rightIndex = itmp;

				swapA[cnt] = j;
				swapB[cnt] = itmp;
				swapMode[cnt] = 1;
				cnt++;
				itmp = j;
				arr[j + 1] = arr[j];
			} else
				break;
		}
		arr[j + 1] = temp;
	}

	num = 0;
	timer = setInterval(insertionAnimation, speed);
}

function downAnimation(i) {
	var v = 5;
	var check = true;
	flag = 0;
	ctx.clearRect(rect[i].sx, rect[i].sy + 300, width, -ran[i] * (height + 10));
	rect[i].sy += v;

	if (rect[i].sy >= 250) {
		rect[i].sy = 250;
		check = false;

		if (num > cnt) {
			isStart = 0;
			stop = 0;
			clearInterval(timer);
			timer = 0;

		}

		num++;
		if (mode == 1)
			drawAll();
		else
			rect[i].draw(basicColor);
		return;
	}
	if (mode == 1)
		drawAll();
	else
		rect[i].draw(basicColor);
}

function upAnimation(i) {
	var v = 5;
	var check = true;
	flag = 0;
	ctx.clearRect(rect[i].sx, rect[i].sy + 300, width, -ran[i] * (height + 10));
	rect[i].sy -= v;
	if (rect[i].sy <= 50) {
		rect[i].sy = 50;
		check = false;
		drawAll();

		if (num > cnt) {
			isStart = 0;
			stop = 0;
			clearInterval(timer);
			timer = 0;

		}
		num++;

		return;
	}
	drawAll();
}

function bubbleAnimation() {
	SwapAnimation();
}

function insertionAnimation() {
	if (swapMode[num] == 1) {
		SwapAnimation();
	} else if (swapMode[num] == 2) {
		downAnimation(swapA[num]);
	} else if (swapMode[num] == 3) {
		upAnimation(swapA[num]);
	} else if (swapMode[num] == 4) {
		rect[swapA[num]].sy = 250;
		rect[swapB[num]].sy = 50;
		drawAll();
		swapMode[num] = 0;
		num++;
	} else
		num++;

	if (cnt < num) {
		isStart = 0;
		stop = 0;
		initdrawall();
		clearInterval(timer);
		timer = 0;
	}
}

function selectionAnimation() {
	if (swapMode[num] == 1) {
		SwapAnimation();
	} else if (swapMode[num] == 2) {

		downAnimation(swapA[num]);
		drawAll();
	} else if (swapMode[num] == 3) {
		initdrawall();
		upAnimation(swapA[num]);

		drawAll();
	} else if (swapMode[num] == 5) {
		if (swapB[num] == 0) {
			initdrawall();
			rect[swapA[num]].fillstyle = "lightgreen";
			rect[swapA[num]].draw();
		} else if (swapB[num] == -1) {
			rect[swapA[num]].fillstyle = "#BD24A9";
		} else if (swapB[num] == -2) {
		}
		num++;
	} else if (swapMode[num] == 6) {
		rect[swapA[num]].fillstyle = "#BD24A9";
		rect[swapB[num]].fillstyle = "lightgreen";
		drawAll();
		num++;

	} else if (swapMode[num] == 7) {
		rect[swapA[num]].fillstyle = "lightgreen";
		rect[swapB[num]].fillstyle = "lightgreen";

		drawAll();
		num++;
	} else
		num++;
	if (cnt < num - 1) {
		isStart = 0;
		stop = 0;
		clearInterval(timer);
		initdrawall();
		timer = 0;
	}
}

function selectionSort(arr) {
	var i = 0, length = arr.length, j = 0, t, min;

	for (i = 0; i < length - 1; i++) {
		min = i;
		swapA[cnt] = i;
		swapB[cnt] = 0;
		swapMode[cnt] = 5;
		cnt++;

		for (j = i + 1; j < length; j++) {
			swapA[cnt] = j;
			swapB[cnt] = min;
			swapMode[cnt] = 6;
			cnt++;

			if (arr[min] > arr[j]) {
				swapA[cnt] = min;
				swapB[cnt] = -1;
				swapMode[cnt] = 5;
				cnt++;

				min = j;

				swapA[cnt] = i;
				swapB[cnt] = min;
				swapMode[cnt] = 7;
				cnt++;

			}
			swapA[cnt] = j;
			swapB[cnt] = -2;
			swapMode[cnt] = 5;
			cnt++;
		}
		SelectSortSwap(i, min);

		temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
	}
	timer = setInterval(selectionAnimation, 1);
}

function SelectSortSwap(i, j) {
	leftx = rect[i].sx;
	rightx = rect[j].sx;
	leftIndex = i, rightIndex = j;

	swapA[cnt] = leftIndex;
	swapB[cnt] = rightIndex;
	swapMode[cnt] = 1;
	cnt++;
}

function partition(low, high) {
	var i, j;
	var tmp;
	var pivoitem = ran[low];

	j = low;

	swapA[cnt] = low;
	swapB[cnt] = high;
	swapMode[cnt] = 6;
	cnt++;

	for (i = low + 1; i <= high; i++) {
		swapA[cnt] = i;
		swapB[cnt] = 0;
		swapMode[cnt] = 7;
		cnt++;
		if (ran[i] < pivoitem) {
			j++;
			quickSortSwap(j, i);
			tmp = ran[i];
			ran[i] = ran[j];
			ran[j] = tmp;
		}
	}
	quickSortSwap(low, j);
	tmp = ran[low];
	ran[low] = ran[j];
	ran[j] = tmp;

	swapMode[cnt] = 8;
	cnt++;
	return j;
}

function quickSort(low, high, t) {
	var pivoindex;
	if (low < high) {
		pivoindex = partition(low, high);
		swapMode[cnt] = 5;
		cnt++;
		quickSort(low, pivoindex - 1, t + 1);
		quickSort(pivoindex + 1, high, t + 1);
	}
	if (t == 0) {
		swapMode[cnt] = 5;
		cnt++;
	}
}

function startQuick() {
	timer = setInterval(quickSortAnimation, 1);
}

function quickSortAnimation() {
	if (swapMode[num] == 1) {
		SwapAnimation();
	} else if (swapMode[num] == 4) {
		rect[swapA[num]].fillstyle = "lightgreen";
		rect[swapB[num]].fillstyle = "#FFFF24";
		drawAll();
		num++;
	} else if (swapMode[num] == 5) {
		initdrawall();
		num++;
	} else if (swapMode[num] == 6) {
		rect[swapA[num]].fillstyle = "#BD24A9";
		rect[swapB[num]].fillstyle = "#BD24A9";
		drawAll();

		num++;
	} else if (swapMode[num] == 7) {
		rect[swapA[num]].fillstyle = "#FFFF24";
		rect[swapA[num]].draw();
		num++;
	} else if (swapMode[num] == 8) {
		drawAll();
		num++;
	} else
		num++;

	if (cnt < num) {
		isStart = 0;
		stop = 0;
		clearInterval(timer);
		timer = 0;
	}
}

function quickSortSwap(i, j) {
	leftx = rect[i].sx;
	rightx = rect[j].sx;
	leftIndex = i, rightIndex = j;

	swapA[cnt] = leftIndex;
	swapB[cnt] = rightIndex;
	swapMode[cnt] = 1;
	cnt++;

	swapA[cnt] = leftIndex;
	swapB[cnt] = rightIndex;
	swapMode[cnt] = 4;
	cnt++;
}

function shellSort(arr) {
	var i = 0, length = arr.length, j = 0, temp, gap;
	gap = 20;

	while (gap > 0) {
		for (i = 0; i < length; i++) {
			j = i;
			temp = arr[i];
			while (j >= gap && arr[j - gap] > temp) {
				leftx = rect[j - gap].sx;
				rightx = rect[j].sx;
				leftIndex = j - gap, rightIndex = j;

				swapA[cnt] = leftIndex;
				swapB[cnt] = rightIndex;
				swapMode[cnt] = 1;
				cnt++;

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

	timer = setInterval(shellSortAnimation, 1);
}

function shellSortAnimation() {
	if (swapMode[num] == 1) {
		SwapAnimation();
	} else if (swapMode[num] == 2) {
		downAnimation(swapA[num]);
	} else if (swapMode[num] == 3) {
		upAnimation(swapA[num]);
	} else if (swapMode[num] == 4) {
		rect[swapA[num]].sy = 250;
		rect[swapB[num]].sy = 50;
		drawAll();
		num++;
	} else
		num++;

	if (cnt < num - 1) {
		isStart = 0;
		stop = 0;

		clearInterval(timer);
		initdrawall();
		timer = 0;
	}
}

function merge(arr, low, mid, high) {
	var startx = rect[low].sx;
	var firstx = rect[low].sx;
	var i, length = arr.length, j, k, t;
	var temp = [];
	var itmp = [];

	t = 0;
	i = low;
	j = mid + 1;
	k = low;

	swapA[cnt] = low;
	swapB[cnt] = high;
	swapMode[cnt] = 4;
	cnt++;

	while (i <= mid && j <= high) {
		if (arr[i] <= arr[j]) {
			swapA[cnt] = i;
			swapB[cnt] = k;
			swapC[cnt] = startx;
			swapMode[cnt] = 6;
			cnt++;

			itmp[k] = i;
			temp[k++] = arr[i++];
			startx += width + margin;
		} else {
			swapA[cnt] = j;
			swapB[cnt] = k;
			swapC[cnt] = startx;
			swapMode[cnt] = 6;
			cnt++;

			itmp[k] = j;
			temp[k++] = arr[j++];
			startx += width + margin;
		}
	}

	if (i > mid) {
		for (t = j; t <= high; t++) {
			swapA[cnt] = t;
			swapB[cnt] = k;
			swapC[cnt] = startx;
			swapMode[cnt] = 6;
			cnt++;

			itmp[k] = t;
			temp[k++] = arr[t];
			startx += width + margin;
		}
	} else {
		for (t = i; t <= mid; t++) {
			swapA[cnt] = t;
			swapB[cnt] = k;
			swapC[cnt] = startx;
			swapMode[cnt] = 6;
			cnt++;

			itmp[k] = t;
			temp[k++] = arr[t];
			startx += width + margin;
		}
	}
	for (t = low; t <= high; t++) {
		arr[t] = temp[t];

		swapA[cnt] = itmp[t];
		swapB[cnt] = 0;
		swapMode[cnt] = 3;
		cnt++;

	}

	swapA[cnt] = low;
	swapB[cnt] = high;
	swapC[cnt] = firstx;
	swapMode[cnt] = 5;
	cnt++;

}

function mergeSort(arr, low, high) {
	var mid;

	if (low < high) {
		mid = (low + high);
		mid = Math.floor(mid / 2);
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
}

function mergeSortStart() {
	timer = setInterval(mergeSortAnimation, 50);
}

function mergeAnimation(indexR, indexT, x) {
	var tmp;
	rect[indexR].sx = x;
	rect[indexR].sy = 250;
	nodeTmp[indexT] = rect[indexR].sheight;
	nodeNum[indexT] = rect[indexR].num;
	drawAll();
}

function mergeInit(low, high, firstx) {
	var t;
	for (t = low; t <= high; t++) {
		console.log("merge");
		rect[t].sx = firstx;
		rect[t].sy = 50;
		rect[t].sheight = nodeTmp[t];
		firstx += width + margin;
		rect[t].num = nodeNum[t];
	}
	drawAll();
	initdrawall();
}

function mergeSortAnimation() {
	if (swapMode[num] == 1) {
		clearInterval(timer);
		timer = setInterval(mergeSortAnimation, 20);
		SwapAnimation();
	} else if (swapMode[num] == 2) {
		clearInterval(timer);
		timer = setInterval(mergeSortAnimation, 30);
		downAnimation(swapA[num]);
	} else if (swapMode[num] == 3) {
		clearInterval(timer);
		timer = setInterval(mergeSortAnimation, 10);
		upAnimation(swapA[num]);
	} else if (swapMode[num] == 4) {
		var t = 0;
		clearInterval(timer);
		timer = setInterval(mergeSortAnimation, 100);
		for (t = swapA[num]; t <= swapB[num]; t++) {
			rect[t].fillstyle = "#" + color;
		}
		drawAll();
		num++;
	} else if (swapMode[num] == 5) {
		var t;
		clearInterval(timer);
		timer = setInterval(mergeSortAnimation, 50);

		mergeInit(swapA[num], swapB[num], swapC[num]);
		num++;
	} else if (swapMode[num] == 6) {
		clearInterval(timer);
		timer = setInterval(mergeSortAnimation, 70);
		mergeAnimation(swapA[num], swapB[num], swapC[num]);
		num++;
	} else
		num++;

	if (cnt < num) {
		isStart = 0;
		stop = 0;
		clearInterval(timer);
		timer = 0;
	}
}

function drawTree(i, startx, starty, gap) {
	if (i >= ran.length || num > cnt) {
		return;
	}
	ctx.strokeStyle = "black";

	if (heapTmp[2 * i + 1]) {
		ctx.moveTo(startx, starty);
		ctx.lineTo(startx - gap, starty + 100);
		ctx.stroke();
	}
	if (heapTmp[2 * (i + 1)]) {
		ctx.moveTo(startx, starty);
		ctx.lineTo(startx + gap, starty + 100);
		ctx.stroke();
	}
	if (heapTmp[i] < 100) {
		ctx.beginPath();
		ctx.arc(startx, starty, 20, 0, 2 * Math.PI);
		ctx.stroke();
		ctx.fillStyle = "white";
		if (swapA[num] == i)
			ctx.fillStyle = "red";
		if (swapB[num] == i)
			ctx.fillStyle = "red";
		ctx.fill();
		ctx.closePath();

		ctx.beginPath();
		ctx.fillStyle = "black";
		if (swapA[num] == i)
			ctx.fillStyle = "white";
		if (swapB[num] == i)
			ctx.fillStyle = "white";
		ctx.font = "25px Lucida Handwriting";
		ctx.textAlign = "center";
		ctx.fillText(heapTmp[i], startx, starty + 10);
		ctx.closePath();
	}

	drawTree((2 * i + 1), startx - gap, starty + 100, gap / 2);
	drawTree(2 * (i + 1), startx + gap, starty + 100, gap / 2);
}

function heapSort() {
	var i, temp;
	var arrayHalf;
	var array_size = ran.length;

	arrayHalf = Math.floor(array_size / 2);

	swapMode[cnt] = 2;
	cnt++;

	for (i = arrayHalf - 1; i >= 0; i--)
		siftDown(i, array_size);

	for (i = array_size - 1; i >= 1; i--) {
		heapSortAnimation(0, i);

		temp = ran[0];
		ran[0] = ran[i];
		ran[i] = temp;
		siftDown(0, i - 1);
	}

	swapMode[cnt] = 3;
	cnt++;
}

function siftDown(root, bottom) {
	var done, maxChild, temp;

	done = 0;
	while ((root * 2 <= bottom) && (!done)) {
		if (root * 2 == bottom)
			maxChild = root * 2;
		else if (ran[root * 2] > ran[root * 2 + 1])
			maxChild = root * 2;
		else
			maxChild = root * 2 + 1;

		if (ran[root] < ran[maxChild]) {
			heapSortAnimation(root, maxChild);

			temp = ran[root];
			ran[root] = ran[maxChild];
			ran[maxChild] = temp;
			root = maxChild;
		} else
			done = 1;

	}
}

function heapSortAnimation(i, j) {

	selectnum1 = i;
	selectnum2 = j;

	leftx = rect[i].sx;
	rightx = rect[j].sx;
	leftIndex = i, rightIndex = j;

	swapA[cnt] = leftIndex;
	swapB[cnt] = rightIndex;
	swapMode[cnt] = 1;
	cnt++;

	selectnum1 = -1;
	selectnum2 = -1;

	swapA[cnt] = 500;
	swapB[cnt] = 500;
	swapMode[cnt] = 3;
	cnt++;
}

function heapStart() {
	num = 0;
	timer = setInterval(heapAnimation, 10);
}

function heapAnimation() {
	if (swapMode[num] == 1) {
		if (flag == 0) {
			var please = heapTmp[swapA[num]];
			heapTmp[swapA[num]] = heapTmp[swapB[num]];
			heapTmp[swapB[num]] = please;
		}

		SwapAnimation();

	} else if (swapMode[num] == 2) {
		ctx.clearRect(0, 0, wcanvas, hcanvas);

		var i;
		for (i = 0; i < ran.length; i++) {
			rect[i].sheight = 50;
			rect[i].sy -= 250;
		}

		drawAll();
		num++;
	} else if (swapMode[num] == 3) {
		initdrawall();
		num++;
	} else
		num++;

	if (cnt < num) {
		isStart = 0;
		stop = 0;
		clearInterval(timer);
		timer = 0;
		return;
	}
	drawTree(0, wcanvas / 2, 200, 100);
}

function initHeap() {
	ctx.clearRect(0, 0, wcanvas, hcanvas);

	var i;
	for (i = 0; i < ran.length; i++) {
		rect[i].sheight = 50;
		rect[i].sy -= 250;
	}

	drawAll();
	drawTree(0, wcanvas / 2, 200, 100);
}
