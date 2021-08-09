<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<!-- html 주석: 소스보기에서 보인다. -->
	<%-- JSP 주석: 소스보기에서 보이지 않는다. --%>
	
	<%
		// 자바 주석, 자바 문법 시작
		// scriptlet
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
	%>
	
	<b>합계:</b>
	<input type="text" value="<%= sum %>">
	<br>
	
	<%!
		// field
		private int num = 100;
	
		// method
		public String getHelloWorld() {
			return "hello world!!!";
		}
	%>
	
	<%= getHelloWorld() %>
	<br>
	<%= num + 200 %>
</body>
</html>