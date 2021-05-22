<!-- XML/HTML 주석 -->
<%-- -JSP 주석 --%>

<%-- page 지시자(디렉티브:directive) : %@ ~~~~ --%>
<!-- 간혹 액션태그로 page directive를 하는 경우가 있는데 실무에서는 안쓴다  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	// 선언부(declaration) : JSE(O), JEE(X)
	// 실무적으로 사용(X) 보안적으로 위험(코드노출 위험)=> 대처법) Java Bean
	public String print() {
		System.out.println("Java code");
		return "Java code";
	}
	
%>

<%-- DOCTYPE : HTML 시작 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
</head>
<body>

<%  // 스크립트릿(scriptlet) : JEE (O), 프로그램 논리(logic) 부분 - 느낌표가 없을때
	// 대체) JSTL
	
	
	String str = "JSP";	// 변수 정의 가능, 함수 정의 불가능
	
	if(str.equals("JSP")) {
		out.println("<b>Servelt의 축약</b> <br>"); // 이부분은 html이다 
	}

	// JSP 기본(내장) 객체 : out ( 웹브라우저 출력)
	// 인스턴스 생성 과정없이 바로 사용하는 객체
	out.println("code : " + print() + "<br>");
	out.println("code : " + print());
%>

<hr>
<%-- 표현식 주의사항) ";" 마무리 X--%>
<%-- 대체) EL --%>
- str: <%=str + " 2.3 " + print() %>
</body>
</html>
