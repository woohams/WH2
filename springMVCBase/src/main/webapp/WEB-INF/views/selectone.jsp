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

	<input type="hidden" name="empno" value="${dto.empno }">
		<table border="1">
			<tr>
				<th>사원 번호</th>
				<td>${dto.empno }</td>
			</tr>
			<tr>
				<th>사원 이름</th>
				<td>${dto.ename }</td>
			</tr>
			<tr>
				<th>사원 급여</th>
				<td>${dto.sal }</td>
			</tr>
			<tr>
				<th>부서 번호</th>
				<td>${dto.deptno }</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" value="수정" onclick="location.href='update.do?empno=${dto.empno}'">
					<input type="button" value="삭제" onclick="location.href='delete.do?empno=${dto.empno}'">
					<input type="button" value="목록" onclick="location.href='list.do'"> 
				</td>
			</tr>
			
			
		</table>
		
	

</body>
</html>