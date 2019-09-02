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
	<input type="hidden" name="seq" value="${dto.seq }"/>
		<table border="1">
			<tr>
				<th>S E Q</th>
				<td><input type="text" name="seq" value="${dto.seq }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>I   D</th>
				<td><input type="text" readonly="readonly" value="${dto.id }"/></td>
			</tr>
			<tr>
				<th>P	W</th>
				<td><input type="text" name="pw" value="${dto.pw }"/></td>
			</tr>
			<tr>
				<th>N A M E</th>
				<td><input type="text" name="name" value="${dto.name }"/></td>
			</tr>
			<tr>
				<th>NICKNAME</th>
				<td><input type="text" name="nickname" value="${dto.nickname }"/></td>
			<tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 완료"/>
					<input type="button" value="뒤로 가기" onclick="location.href='selectone.do?seq=${dto.seq}'"/>
					<input type="button" value="목록" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>