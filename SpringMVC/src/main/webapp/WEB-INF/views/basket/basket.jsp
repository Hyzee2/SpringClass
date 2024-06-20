<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="basket" value="${basketlist}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 내역</title>
<c:import url="../user/NavBar.jsp"></c:import>
<style>
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        text-align: left;
    }
    th, td {
        padding: 8px;
        border: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    input[type="button"] {
        width: 30px;
    }
    .submit{
    	float: right;
    	margin: auto 100px;
    }
</style>
<script>
	function updateQuantity(index, isPlus){ // +, - 따라 장바구니 수량 조절하기 
		var qtyInput = document.getElementById("quantity"+index);
		var item_total = parseInt(qtyInput.value.trim());
		console.log("item_total은 "+item_total);
		
		if(isPlus){
			item_total++;
		}else{
			if(item_total>1){
				item_total--;
			}
		}
		
		var item = 'item_name'+index;
		var item_name = document.getElementById(item).value;
		console.log("item_name은 "+item_name);
		console.log("변경된 item_total은 "+item_total);
		
		qtyInput.value = item_total;
		updateTotal(index);
	}
	
	function updateTotal(index){ // 각 상품별 합계 조절하기 
		var qty = parseInt(document.getElementById('quantity'+index).value.trim());
		var price = parseFloat(document.getElementById('price'+index).innerText.replace('원', '').trim());
		var total = qty*price;
		document.getElementById('total'+index).innerText = total.toLocaleString()+'원';
		calculateTotalSum();
	}
	
	function calculateTotalSum(){ // 모든 상품 최종 합계 구하기 
		var rows = document.querySelectorAll('.row-item');
		var totalSum = 0;
		rows.forEach(function(row){
			var total = parseFloat(row.querySelector('.item-total').innerText.replace('원', '').replace(/,/g, '').trim());
			totalSum += total;
		});
		document.getElementById('finalTotal').innerText = totalSum.toLocaleString()+'원';
	}
</script>
</head>
<body>
<c:choose>
<c:when test="${empty id}">
	<script>
		alert("로그인 후 이용해주세요.");
		location.href="../user/login";
	</script>
</c:when>
<c:otherwise>
<h2 style="text-align:center;">장바구니 페이지</h2>
<form action="../basket/basketModify" method="post">
	<table>
	    <tr>
	        <th>상품명</th>
	        <th>가격</th>
	        <th>수량</th>
	        <th>합계</th>
	    </tr>
	    
	<c:forEach var="cart" items="${basket}" varStatus="status">
	    <tr class="row-item">
	        <td>
	        	${cart.item_name}
	        	<input type="hidden" id="item_name${status.index}" name="item_name" value="${cart.item_name}" />
	        </td>
	        <td name="item_price" id="price${status.index}">${cart.item_price}원</td>
	        <td>
	        	<input type="button" value="-" onclick="updateQuantity(${status.index}, false)" />
	        	<input name="item_total" type="text" id="quantity${status.index}" value="${cart.item_total}" readonly style="width:40px; text-align:center;" />
	        	<input type="button" value="+" onclick="updateQuantity(${status.index}, true)" />
	        </td>
	        <td id="total${status.index}" class="item-total">${cart.item_price*cart.item_total}</td>
	        
	    </tr>
	</c:forEach>
		<tr>
			<td colspan="3" style="text-align:right;">최종합계: </td>
			<td id="finalTotal"></td>
		</tr>
	</table>
	<button class="submit" onclick="submitBasket(this.form)">최종 결제하기</button>
</form>
</c:otherwise>
</c:choose>

<script>
	window.onload = function(){
		var rows = document.querySelectorAll('.row-item');
		rows.forEach(function(row, index){
			updateTotal(index);
		});
	};
	
	function submitBasket(form){
		alert("최종 결제를 진행합니다.");
		form.submit();
		
	}
</script>
</body>
</html>