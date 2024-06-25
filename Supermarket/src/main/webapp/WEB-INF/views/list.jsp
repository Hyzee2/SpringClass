<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑리스트</title>
<script src="https://cdn.tailwindcss.com"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="icon" type="image/png" href="resources/emart.png">
<style>
.img {
	height: 100px;
	width: 100px
}

@font-face {
	font-family: 'SUITE-Regular';
	src:
		url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2')
		format('woff2');
	font-weight: 400;
	font-style: normal;
}

* {
	font-family: 'SUITE-Regular';
}
</style>
<script>
	// 수량 증가
	function increase(cookie) {
		let cnt = document.getElementById("quantity" + cookie);
		let quantity = parseInt(cnt.value);
		cnt.value = quantity + 1;
	}

	// 수량 감소
	function decrease(cookie) {
		let cnt = document.getElementById("quantity" + cookie);
		let quantity = parseInt(cnt.value);
		if (quantity > 0) {
			cnt.value = quantity - 1;
		}
	}

	function isEmpty() {
		let cookies = [ "Ame", "Double", "Otmeal" ];
		let allEmpty = true;

		for (let i = 0; i < 3; i++) {
			let cnt = document.getElementById("quantity" + cookies[i]).value;
			console.log(cnt);
			if (parseInt(cnt) > 0) {
				allEmpty = false;
				break;
			}
		}

		if (allEmpty) {
			alert("1개 이상의 상품을 선택해주세요!");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<p class="text-4xl my-8 text-center">🍪 쿠키 상품 목록</p>
	<div class="d-flex justify-content-center text-center">
		<div class="mx-auto" style="width: 65%;">
			<div class="w-100">
				<form name="List" method="post" action="listAdd">
					<table class="table">
						<tr>
							<th class="table-warning">제품 사진</th>
							<th class="table-warning">제품명</th>
							<th class="table-warning">제품가격</th>
							<th class="table-warning">수량</th>
						</tr>
						<tr>
							<td><img src="resources/cookie1.png" class="img mx-auto" /></td>
							<td class="align-middle"><p class="fs-4">AmericanCookie</p></td>
							<input type="hidden" name="name" value="AmericanCookie" />
							<td class="align-middle">3,000원</td>
							<input type="hidden" name="price" value="3000" />
							<td class="align-middle"><input type="button" value="-"
								name="decreaseAme" onclick="decrease('Ame')"
								class="btn btn-outline-primary" /> <input type="number"
								name="count" id="quantityAme" value="0" style="width: 30px" />
								<input type="button" value="+" name="increaseAme"
								onclick="increase('Ame')" class="btn btn-outline-primary" /></td>
						</tr>
						<tr>
							<td><img src="resources/cookie2.png" class="img mx-auto" /></td>
							<td class="align-middle"><p class="fs-4">DoubleChocoCookie</p></td>
							<input type="hidden" name="name" value="DoubleChocoCookie" />
							<td class="align-middle">2,800원</td>
							<input type="hidden" name="price" value="2800" />
							<td class="align-middle"><input type="button" value="-"
								name="decreaseDouble" onclick="decrease('Double')"
								class="btn btn-outline-primary" /> <input type="number"
								name="count" id="quantityDouble" value="0"
								style="width: 30px" /> <input type="button" value="+"
								name="increaseDouble" onclick="increase('Double')"
								class="btn btn-outline-primary" /></td>
						</tr>
						<tr>
							<td><img src="resources/cookie3.png" class="img mx-auto" /></td>
							<td class="align-middle"><p class="fs-4">LimeCookie</p></td>
							<input type="hidden" name="name" value="LimeCookie" />
							<td class="align-middle">2,600원</td>
							<input type="hidden" name="price" value="2600" />
							<td class="align-middle"><input type="button" value="-"
								name="decreaseOtmeal" onclick="decrease('Otmeal')"
								class="btn btn-outline-primary" /> <input type="number"
								name="count" id="quantityOtmeal" value="0"
								style="width: 30px" /> <input type="button" value="+"
								name="increaseOtmeal" onclick="increase('Otmeal')"
								class="btn btn-outline-primary" /></td>
						</tr>
					</table>
					<div class="d-flex justify-content-end">
						<input type=submit name=intoCart value="장바구니 담기 및 이동"
							style="margin-top: 20px" class="m-4 btn btn-outline-success" />
						<input type=button name=intoCart value="장바구니 이동" onclick="location.href='./cart'"
							style="margin-top: 20px" class="m-4 btn btn-outline-warning" />
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>