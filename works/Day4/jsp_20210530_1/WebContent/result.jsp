<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
result : <%=request.getAttribute("txt2") %><br>
result : ${requestScope.txt2}<br>
result : ${txt2}<br>
result : <c:out value="${txt2}&copy;" escapeXml="true"/><br>
result : <c:out value="${txt2}&copy;" escapeXml="false"/><br>
result : <c:out value="<${txt2}>" escapeXml="true"/><br>
result : <c:out value="<${txt2}>" escapeXml="false"/><br>
result : <c:out value="&lt;${txt2}&gt;" escapeXml="false"/><br>
</body>
</html>