<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3월 달력</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<%
		Calendar thisMonth = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		thisMonth.add(Calendar.MONTH, -5);
		thisMonth.set(Calendar.DATE, thisMonth.getActualMaximum(Calendar.DATE));
		int weeksOfMonth = thisMonth.get(Calendar.WEEK_OF_MONTH);;
		thisMonth.set(Calendar.DATE, 1);
		int month = thisMonth.get(Calendar.MONTH);
		/* Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(thisMonth.get(Calendar.MONTH) == 2) {
			map.put(thisMonth.get(Calendar.DATE), thisMonth.get(Calendar.DAY_OF_WEEK));
			weeksOfMonth = thisMonth.get(Calendar.WEEK_OF_MONTH);
			thisMonth.add(Calendar.DATE, 1);
		} */
		/* thisMonth.add(Calendar.MONTH, -1); */
	%>
	
	
	<div class="container">
		<h1 class="text-center"><%= sdf.format(thisMonth.getTime()) %></h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-danger">일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
				</tr>
			</thead>
			<tbody>
				<%
					int date = 1;
					for (int i = 0; i < weeksOfMonth; i++) {
				%>
				<tr class="display-4">
					<%
						for (int j = 1; j <= 7; j++) {
							if (thisMonth.get(Calendar.DAY_OF_WEEK) == j && thisMonth.get(Calendar.MONTH) == month) {
					%>
					<td><%= date %></td>
					<%
								date++;
								thisMonth.add(Calendar.DATE, 1);
							} else {
					%>
					<td></td>
					<%
							}
						}
					%>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>