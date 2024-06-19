<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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
<style>
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
</head>
<body>
	<div class="flex justify-center flex-col text-center">
		<%@ include file="titleBar.jsp"%>
		<div class="flex justify-center">
			<table class="table table-bordered" style="width: 60%;">
				<form action="write" method="post">
					<tr>
						<td>이름</td>
						<td><input type="text" name="bName" size="50" class="w-100"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle" size="50" class="w-100"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="bContent" rows="10" class="w-100"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록"
								class="btn btn-warning" /> &nbsp;&nbsp;
							<a href="list"><input type="button" value="목록보기" class="btn btn-primary"></a></td>
					</tr>
				</form>
			</table>
		</div>
	</div>

</body>
</html>