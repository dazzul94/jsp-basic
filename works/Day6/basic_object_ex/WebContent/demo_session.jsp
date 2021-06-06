<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page import="java.util.List" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%
		List<String> list = (List<String>)session.getAttribute("cart");
	
		for(String s : list) {
			out.println(s + "<br>");
		}
	%> --%>
	
	
	session : ${sessionScope.cart} <br>
	<c:forEach items="${sessionScope.cart}" var="c" varStatus="st" >
		${st.count} : ${c} <br>
	</c:forEach>
</body>
</html>