<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>전화번호부</h1>
	<h2>리스트</h2>
	
	<p>등록된 전화번호 리스트 입니다.<p>
	<c:forEach items="${pList}" var="PersonVo" varStatus="status">
	
		<table border="1">
			
			<tr>
				<td>이름(name)</td> <td>${PersonVo.name}</td>			
			</tr>
			<tr>
				<td>핸드폰(hp)</td> <td>${PersonVo.hp}</td>		
			</tr>
			<tr>
				<td>회사(company)</td> <td>${PersonVo.company}</td>			
			</tr>
			
			<tr>
				<td> <a href="./pbc?action=uFrom&id=${PersonVo.personId}&name=${PersonVo.name}&hp=${PersonVo.hp}&company=${PersonVo.company}">[수정]</td>
				<td> <a href="./pbc?action=delete&id=${PersonVo.personId}">[삭제]</a> </td>	
			</tr>
			
		</table>
		<br>
	
	</c:forEach>
	
	<a href="./pbc?action=wfrom">전화번호 등록품</a>













</body>
</html>