<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<h1>사원 정보</h1>
	
	<table border="1">
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td>사원정보가 없습니다</td>
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
						<input type="button" onclick="location.href='insert.do'" value="ì¬ì ì¶ê°">
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</table>
</body>
</html>
