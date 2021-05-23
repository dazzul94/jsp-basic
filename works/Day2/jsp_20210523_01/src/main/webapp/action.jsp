<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action</title>
</head>

<!-- post 방식 only -->
<!-- HTTP 요청 기본(내장) 객체(인스턴스) -->
<% request.setCharacterEncoding("UTF-8"); %>
<body>

	인자1: <%= request.getParameter("name1") %><br>
	인자2: <%= request.getParameter("name2") %>
	
</body>
</html>