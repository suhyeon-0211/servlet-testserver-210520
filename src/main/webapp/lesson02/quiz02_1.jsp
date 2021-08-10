<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz02</title>
</head>
<body>
	<%!
		public String getTimeOrDate(String type) {
			Date now = new Date();
			if (type.equals("time")){
				SimpleDateFormat sdf = new SimpleDateFormat("현재 시간은 HH시 mm분 ss초 입니다.");
				return sdf.format(now);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("현재 날짜는 yyyy년 MM월 dd일 입니다.");
				return sdf.format(now);
			}
		}
		
	%>
	
	<%
		String type = request.getParameter("type");
		String result = getTimeOrDate(type);
	%>
	
	<div class="container">
		<h1><%= result %></h1>
	</div>
	
</body>
</html>