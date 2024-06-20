<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="boardList" value="${boardlist}" />
<c:set var="listcount" value="${listcount}" />
<c:set var="nowpage" value="${page}" />
<c:set var="maxpage" value="${maxpage}" />
<c:set var="startpage" value="${startpage}" />
<c:set var="endpage" value="${endpage}" />
<html>
<head>
	<title>게시판</title>
	<c:import url="../user/NavBar.jsp"/>
</head>
<body>
<!-- 게시판 리스트 -->
<BR>
<BR>
<table width=50% border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">게시판</td>
		<td align=right>
			<font size=2>글 개수 : ${listcount }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	
	<c:forEach var="bl" items="${boardList}">
    <tr align="center" valign="middle" bordercolor="#333333"
        onmouseover="this.style.backgroundColor='F8F8F8'"
        onmouseout="this.style.backgroundColor=''">
        <td height="23" style="font-family:Tahoma;font-size:10pt;">
            ${bl.BOARD_NUM}
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="left">
                <c:choose>
                    <c:when test="${bl.BOARD_RE_LEV != 0}">
                        <c:forEach begin="0" end="${bl.BOARD_RE_LEV*2}">
                            &nbsp;
                        </c:forEach>
                        ▶
                    </c:when>
                    <c:otherwise>
                        ▶
                    </c:otherwise>
                </c:choose>
                <a href="../board/boardDetail?num=${bl.BOARD_NUM}">
                    ${bl.BOARD_SUBJECT}
                </a>
            </div>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="center">${bl.BOARD_NAME}</div>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="center">${bl.BOARD_DATE}</div>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="center">${bl.BOARD_READCOUNT}</div>
        </td>
    </tr>
</c:forEach>
	<tr align="center" height="20">
    <td colspan="7" style="font-family:Tahoma;font-size:10pt;">
        <c:choose>
            <c:when test="${nowpage <= 1}">
                [이전]&nbsp;
            </c:when>
            <c:otherwise>
                <a href="../board/boardlist?page=${nowpage-1}">[이전]</a>&nbsp;
            </c:otherwise>
        </c:choose>
        <c:forEach begin="${startpage}" end="${endpage}" var="a">
            <c:choose>
                <c:when test="${a eq nowpage}">
                    [<c:out value="${a}"/>]
                </c:when>
                <c:otherwise>
                    <a href="../board/boardlist?page=${a}">[<c:out value="${a}"/>]</a>&nbsp;
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${nowpage >= maxpage}">
                [다음]
            </c:when>
            <c:otherwise>
                <a href="../board/boardlist?page=${nowpage+1}">[다음]</a>
            </c:otherwise>
        </c:choose>
    </td>
</tr>
	<tr align="right">
		<td colspan="5">
	   		<a href="../board/boardWrite">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>
</html>