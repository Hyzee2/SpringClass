<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="../resources/style.css">
<style>
#title {
	text-align: center;
	font-size: 15pt;
	font-weight: bold;
	text-decoration: #380B61;
}

#self {
	text-align: center;
}

#image {
	height: 150px;
	text-align: center;
}

img {
	height: 100%;
}

input {
	border-style: solid;
	border-color: #BDBDBD;
}

table {
	background-color: #FAFAFA;
}

.subtitle {
	text-decoration: #380B61;
	font-weight: bold;
	text-align: center;
}
</style>
<script>
function showBirth() { // 생년월일 보여주기
    var inputIdnum = document.getElementById("Idnum").value;
    var numArray = inputIdnum.split("", 13);

    if (numArray[7] == 3 || numArray[7] == 4) {
        var y = numArray.slice(0, 1);
        var year = "20" + y.join("");
        var month = numArray[2] + numArray[3];
        var day = numArray[4] + numArray[5];

    } else {
        var y = numArray.slice(0, 2);
        var year = "19" + y.join("");
        var month = numArray[2] + numArray[3];
        var day = numArray[4] + numArray[5];
    }

    document.getElementById("year").value = year;
    document.getElementById("month").value = month;
    document.getElementById("day").value = day;
}
</script>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form id="form" action="joinConfirm" method="post">
		<table class="font" width="800 height=" 700" border="1"
			style="border-collapse: collapse" bordercolor="#A4A4A4"
			align="center">
			<tr id="title" class="font">
				<td colspan="3" , bgcolor="#E6E0F8" height="40">회원 기본 정보</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">아이디</td>
				<td colspan="2"><input type="text" id="id" name="id"
					size"20" maxlength="14" value="${user.id}"> 4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">비밀번호</td>
				<td colspan="2"><input type="password" id="pw" name="pw"
					size"20" maxlength="14" value="${user.pw}"> 4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">비밀번호 확인</td>
				<td colspan="2"><input type="password" id="secondPw"
					name="secondPw" size"20" maxlength="14" value="${user.secondPw}"></td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">메일주소</td>
				<td colspan="2"><input type="text" id="mail" name="mail"
					size"30" maxlength="20" value="${user.mail}"> 예)id@domain.com</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">이름</td>
				<td colspan="2"><input type="text" name="name"
					size"30" maxlength="20" value="${user.name}"></td>
			</tr>

			<tr id="title">
				<td colspan="3" , bgcolor="#E6E0F8" height="40">개인 신상 정보</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">주민등록번호</td>
				<td colspan="2"><input type="text" id="Idnum" name="IDnum"
					size"30" maxlength="20" value="${user.IDnum}" onkeyup="showBirth();">
					예)123456-1234567</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">생일</td>
				<td colspan="2"><input type="text" id="year" name="birth"
					size="5" maxlength="4" readonly>년 <input type="text"
					id="month" name="birth" size="5" maxlength="4" readonly>월 <input
					type="text" id="day" name="birth" size="5" maxlength="4" readonly>일

				</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">관심분야</td>
				<td colspan="2"><input type="checkbox" name="hobby" value="컴퓨터">컴퓨터
					<input type="checkbox" name="hobby" value="인터넷">인터넷 <input
					type="checkbox" name="hobby" value="여행">여행 <input
					type="checkbox" name="hobby" value="영화감상">영화감상 <input
					type="checkbox" name="hobby" value="음악감상">음악감상</td>
			</tr>

			<tr>
				<td class="subtitle" bgcolor="#E6E6E6">자기소개</td>
				<td id="self"><textarea id="intro" name="introduction"
						cols="60" rows="7"></textarea></td>

			</tr>

		</table>

		<p style align="center">
			<input type="submit" value="전송하기"> <input type="reset"
				value="다시입력">
		</p>
	</form>
</body>
</html>