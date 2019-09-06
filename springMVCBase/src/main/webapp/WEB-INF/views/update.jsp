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

	<form action="updateres.do" method="post">
	<input type="hidden" name="empno" value="${dto.empno }"/>
		<table border="1">
			<tr>
				<th>사원 번호</th>
				<td><input type="text" readonly="readonly" value="${dto.empno }"/></td>
			</tr>
			<tr>
				<th>사원 이름</th>
				<td><input type="text" name="password" value="${dto.ename }"/></td>
			</tr>
			<tr>
				<th>사원 급여</th>
				<td><input type="text" name="name" value="${dto.sal }"/></td>
			</tr>
			<tr>
				<th>부서 번호</th>
				<td><input type="text" name="name" value="${dto.deptno }"/></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="수정 완료"/>
					<input type="button" value="뒤로 가기" onclick="location.href='selectone.do?empno=${dto.empno}'"/>
					<input type="button" value="목록" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>