<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action2</title>
</head>

<!-- post 방식 only -->
<!-- HTTP 요청 기본(내장) 객체(인스턴스) -->
<% request.setCharacterEncoding("UTF-8"); %>

<body>
	<% 
	
	// checkbox롸 같이 한개의 필드가 다수의 값을 가질 경우 인자처리
	String name5[] = request.getParameterValues("name5");
	for(String name : name5) {
		out.println(name + " ");
	}
	%>
</body>
</html>