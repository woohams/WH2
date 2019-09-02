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

	
		<table border="1">
			<tr>
				<th>S E Q</th>
				<td>${dto.seq }</td>
			</tr>
			<tr>
				<th>I   D</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>P	W</th>
				<td>${dto.pw }</td>
			</tr>
			<tr>
				<th>N A M E</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<th>NICKNAME</th>
				<td>${dto.nickname }</td>
			<tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='update.do?seq=${dto.seq}'">
					<input type="button" value="삭제" onclick="location.href='delete.do?seq=${dto.seq}'">
					<input type="button" value="목록" onclick="location.href='list.do'"> 
				</td>
			</tr>
			
			
		</table>
		
	

</body>
</html>