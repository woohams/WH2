<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전체 목록</h1>
	
	<table border="1">
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td><h3>고객 정보가 없습니다</h3></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<th>SEQ</th>
					<th>ID</th>
					<th>NAME</th>
					<th>NICKNAME</th>
				</tr>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.seq }</td>
						<td><a href="selectone.do?seq=${dto.seq}">${dto.id}</a></td>
						<td>${dto.name}</td>
						<td>${dto.nickname }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<input type="button" onclick="location.href='insert.do'" value="고객 추가">
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</table>



</body>
</html>