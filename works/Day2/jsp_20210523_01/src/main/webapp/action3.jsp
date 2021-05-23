<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action3</title>
</head>

<!-- post 방식 only -->
<!-- HTTP 요청 기본(내장) 객체(인스턴스) -->
<% request.setCharacterEncoding("UTF-8"); %>

<body>
	<%
		// 인자의 이름들: 반복자 패턴(iterator : Iterator, Enumeration)
		// index 검색방식(X), 다음(next) 요소 검색방식(O) : 성능 향상
		Enumeration<String> enums = request.getParameterNames();
		while(enums.hasMoreElements()) {
			
			// 낱개의 인자명(이름)
			String name = enums.nextElement();
			String[] value = request.getParameterValues(name);
			
			// 인자의 값이 낱개일 경우
			if(value.length == 1) {
				out.println(name + ": " + value[0] + "<br>");
			} else {	// 인자의 값이 다수일 경우(ex. checkbox)
				
				out.println(name + " : ");
			
				for(String n : value) {
					out.println(n + " ");
				}
				
				out.println("<br>");
				
			}
		}
	%>
</body>
</html>