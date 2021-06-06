<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<HTML lang="ko">
<HEAD>
<TITLE> response 객체 </TITLE>
</HEAD>
<BODY>

JSP 환경 설정을 위한 다운로드 페이지 입니다.

<FORM action="response_2.jsp" method="get">

<select name="download">
	<option value="1">JDK</option>
	<option value="2">Tomcat</option>
	<option value="3">eclipse </option>
	<option selected value="4">oracle</option>
</select>

<hr>
JDK: <input type="radio" name="download2" value="1"> &nbsp;
Tomcat: <input type="radio" name="download2" value="2" checked> &nbsp;
eclipse: <input type="radio" name="download2" value="3"> &nbsp;
oracle: <input type="radio" name="download2" value="4"> &nbsp;


<input type="submit" value="이동">

</form>

</BODY>
</HTML>
