<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/CSS.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>Join</title>
<style>
	td{
		text-align : left;
	}
</style>
<script>
	function Check(){
        var pw = document.forms["joinForm"]["user_pw"].value;
        var pw2 = document.forms["joinForm"]["user_pw2"].value;
        var id = document.forms["joinForm"]["user_id"].value;
        
        if(id == "" || pw == "" || pw2 == ""){
        	alert("ID와 PW는 필수 입력사항입니다!");
        	return false;
        }
        
        if (pw != pw2) {
            alert("비밀번호가 잘못 입력되었습니다!");
            return false; 
        }
        
        if (id.length < 4 || id.length > 12) {
            alert("ID는 4~12자 사이로 입력해주세요!");
            return false;
        } else {

            for (var i = 0; i < id.length; i++) {
                var charId = id.charCodeAt(i);
                if (!((charId > 47 && charId < 59) ||
                    (charId > 64 && charId < 91) ||
                    (charId > 96 && charId < 123))) {
                    alert("ID는 영문 대소문자와 숫자로만 입력해주세요!");
                    return false;
                }
            }
        }
        
        if (pw.length < 4 || pw.length > 12) {
             alert("PW는 4~12자 사이로 입력해주세요!");
             return false;
           } else {
               for (var i = 0; i < pw.length; i++) {
                   var charPw = pw.charCodeAt(i);
                   if (!((charPw > 47 && charPw < 59) ||
                       (charPw > 64 && charPw < 91) ||
                       (charPw > 96 && charPw < 123))) {
                       alert("pw는 영문 대소문자와 숫자로만 입력해주세요!");
                       return false;
                    }
                }
            }
            
        
        var email = document.getElementById("user_email").value;


        var idx = email.indexOf("@");
        if (idx == -1 || idx == 0 || idx == email.length - 1) {
            alert("email은 id@domain.com 형식으로 입력해주세요!");
            return false;
        }

        return true;
    }
</script>
</head>
<body>
    <div style="text-align: center;">
        <h3 class="fw-bold my-3"> 회원 가입 </h3>
        <hr><br>
        <div align='center' >
			<form name="joinForm" method=post action="joinAction" onsubmit="return Check()">
				<table class="table table-hover" style="width: 50%">
					<tr>
						<td class="subtitle" colspan='2'>
							<h5 class="subtitle fw-bold">회원 기본 정보</h5>
						</td>
					</tr>
					<tr>
						<td style="width : 10%">아이디 :</td>
						<td><input type='text' name="user_id" class='form-control w-50' id="user_id"
						placeholder="4~12자의 영문 대소문자와 숫자로만 입력"></input>
						</td>
					</tr>
					<tr>
						<td>비밀번호 :</td>
						<td><input type='password' name="user_pw" class='form-control w-50' id="user_pw"
						placeholder="4~12자의 영문 대소문자와 숫자로만 입력"></input>
						</td>
					</tr>
					<tr>
						<td>비밀번호 확인:</td>
						<td><input type='password' name="user_pw2" class='form-control w-50' id="user_pw2"
						placeholder="4~12자의 영문 대소문자와 숫자로만 입력"></input>
						</td>
					</tr>
					<tr>
						<td>메일 주소:</td>
						<td><input type="text" name="user_email" class='form-control w-50' id="user_email"
						placeholder="예) id@domain.com"></input>
							
					</tr>
					</table>
				</div>
				
				<div style="margin: 20px;">
				
					<input type="submit" class="btn btn-success" value="회원 가입">
					<input type="reset"  class="btn btn-danger" value="다시 입력">
					<a href="javascript:history.back()" class="btn btn-secondary">이전</a>
				</div>
			</form>

	</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	
</body>
</html>