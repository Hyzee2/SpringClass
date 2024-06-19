<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<style>
img {
	height: 20px;
	width: 20px;
}
</style>
<script>
	function removeCookie(cookieName) {
		var form = document.createElement('form');
		document.body.appendChild(form);
		form.method = 'post';
		form.action = 'removeCookie.jsp';

		var input = document.createElement('input');
		input.type = 'hidden';
		input.name = 'cookieName';
		input.value = cookieName;
		form.appendChild(input);

		form.submit();
	}
</script>

</head>
<body>
	<h1>CookieCart</h1>
	<hr>
	<form method="post" action="check.jsp">
		<table border="1">
			<tr>
				<th>제품사진</th>
				<th>제품명</th>
				<th>개당 가격</th>
				<th>수량</th>
				<th>합계</th>
				<th>삭제</th>
			</tr>
			<tr>
				<th>꾸끼</th>
				<th>꾸끼</th>
				<th>꾸끼</th>
				<th>꾸끼</th>
				<th>꾸끼</th>
				<th>꾸끼</th>
			</tr>
		</table>
		<p>총 가격 : 원</p>
		<input type=submit onclick="check()" value="결제"
			style="margin-top: 10px" /> <br> <input type=button
			onclick="prev()" value="장바구니 추가담기" style="margin-top: 20px" />
	</form>

</body>
</html>