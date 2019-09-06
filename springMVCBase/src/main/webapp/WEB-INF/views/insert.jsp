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
				<th>사원 번호</th>
				<td><input type="text" name="empno"></td>
			</tr>
			<tr>
				<th>사원 이름</th>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<th>급	여</th>
				<td><input type="text" name="급여"></td>
			</tr>
			<tr>
				<th>부서 번호</th>
				<td><input type="text" name="부서번호"></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="사원 등록"/>
					<input type="button" value="목록" onclick="location.href='list.do'"/>
				</td>
			</tr> 
		</table>
	
	
	</form>

</body>
</html>