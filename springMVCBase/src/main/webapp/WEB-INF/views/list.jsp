<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h1>사원 목록</h1>
	
	<table border="1">
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td>~~~~~~~~~~~~~사원이 존재하지 않습니다~~~~~~~~~~~~~</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<th>EMPNO</th>
					<th>ENAME</th>
					<th>SAL</th>
					<th>DEPTNO</th>
				</tr>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.empno}</td>
						<td><a href="selectone.do?empno=${dto.empno}">${dto.ename}</a></td>
						<td>${dto.sal}</td>
						<td>${dto.deptno}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">
						<input type="button" onclick="location.href='insert.do'" value="사원 추가">
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</table>
</body>
</html>
