<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전화번호부</h1>
	<h2>등록폼</h2>
	
	<p>정보를 등록하는 폼입니다. 정보를 등록하고 등록버튼을 누르세요.</p>
	
	<%-- 여기주소에 insert.jsp를 포함하여 get (엔터치는 효과) --%>
	
	<form action="/phonebook3/pbc" method="get">
		<input type="hidden" name="action" value="insert">
		이름(name): <input type="text" name="name" value=""><br>
		핸드폰(hp): <input type="text" name="hp" value=""><br>
		회사(company): <input type="text" name="company" value=""><br>
		
		<button type="submit">등록</button>
	</form>
	
	
	
	<br>
	<br>
	
	<a href="./pbc?action=list">리스트로 바로가기</a>

</body>
</html>