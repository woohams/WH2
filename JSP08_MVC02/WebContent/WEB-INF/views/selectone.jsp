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

	<input type="hidden" name="seq" value="${dto.seq }">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${dto.writer }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="40" readonly="readonly">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='updateform.do?seq=${dto.seq}'">
					<input type="button" value="삭제" onclick="location.href='delete.do?seq=${dto.seq}'">
					<input type="button" value="목록" onclick="location.href='boardlist.do'"> 
				</td>
			</tr>
			
		</table>	

	
</body>
</html>