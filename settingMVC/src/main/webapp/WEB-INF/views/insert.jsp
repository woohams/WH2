<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="insertres.do" method="post">
	
		<table border="1">
			<tr>
				<th>I   D</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>P	W</th>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<th>N A M E</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>NICKNAME</th>
				<td><input type="text" name="nickname"></td>
			<tr>
				<td colspan="2">
					<input type="submit" value="아이디 생성"/>
					<input type="button" value="목록" onclick="location.href='list.do'"/>
				</td>
			</tr> 
		</table>
	
	
	</form>

</body>
</html>