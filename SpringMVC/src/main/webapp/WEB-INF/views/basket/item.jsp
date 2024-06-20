<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 리스트</title>
<c:import url="../user/NavBar.jsp"/>
</head>
<body>
<script>
	function total(op, id){
		/* let sum = parseInt(document.getElementById(id).value); */
		let sumElement = document.getElementById(id);
		let sum = parseInt(sumElement.value.trim());
		
		switch(op){
		case "+":
			sum++;
			break;
		case "-":
			if(sum == 0){
				alert("현재 수량은 0 입니다.");
				break;
			}else{
				sum--;
				break;
			}
		}
		sumElement.value = sum;
		/* document.getElementById(id).value = sum; */
	}
</script>
<table align="center" border="1" width="50%">
	<tr>
		<th>상품명</th>
		<th>가격</th>
		<th>구매수량</th>
	</tr>
	<tr>
		<form action="../basket/basketAdd" method="post">
			<td>라이언</td>
			<td>10,000원</td>
			<td>
				<input type="hidden" name="item_name" value="라이언" />
				<input type="hidden" name="item_price" value="10000" />
				<input type="button" name="minus" value="-" onclick='total("-", "sum1");'/>
				<input id="sum1" type="text" name="item_total" value="0" readonly style="width:30px;"/>
				<input type="button" name="plus" value="+" onclick='total("+", "sum1");'/>
				<input type="submit" name="submit" value="장바구니에 담기" />
			</td>
			
		</form>
	</tr>
	<tr>
		<form action="../basket/basketAdd" method="post">
			<td>어피치</td>
			<td>20,000원</td>
			<td>
				<input type="hidden" name="item_name" value="어피치" />
				<input type="hidden" name="item_price" value="20000" />
				<input type="button" name="minus" value="-" onclick='total("-", "sum2");'/>
				<input id="sum2" type="text" name="item_total" value="0" readonly style="width:30px;"/>
				<input type="button" name="plus" value="+" onclick='total("+", "sum2");'/>
				<input type="submit" name="submit" value="장바구니에 담기" />
			</td>
		
		</form>
	</tr>
	<tr>
		<form action="../basket/basketAdd" method="post">
			<td>무지</td>
			<td>30,000원</td>
			<td>
				<input type="hidden" name="item_name" value="무지" />
				<input type="hidden" name="item_price" value="30000" />
				<input type="button" name="minus" value="-" onclick='total("-", "sum3");'/>
				<input id="sum3" type="text" name="item_total" value="0" readonly style="width:30px;"/>
				<input type="button" name="plus" value="+" onclick='total("+", "sum3");'/>
				<input type="submit" name="submit" value="장바구니에 담기" />
			</td>
		
		</form>
	</tr>
</table>
</body>
</html>