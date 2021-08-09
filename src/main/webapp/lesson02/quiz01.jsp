<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz01</title>
</head>
<body>
	<%!
		
		public int sum(int n) {
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += i;
			}
		return sum;
		}
	%>
	<h2>1부터 50까지의 합은 <%= sum(50) %>입니다.</h2>
	
	<%
		int[] scores = {80, 90, 100, 95, 80};
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		double avg = sum / (double)scores.length;
	%>
	<h2>평균 점수는 <%= avg %>입니다.</h2>
	
	<%
		List<String> scoreList = Arrays.asList(new String[]{"X", "O", "O", "O", "X", "O", "O", "O", "X", "O"});
		sum = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i).equals("O")) {
				sum += 100 / scoreList.size();
			}
		}
	%>
	<h2>채점 결과는 <%= sum %>점 입니다.</h2>
	
	<%
		String birthDay = "20010820";
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String thisYear = sdf.format(today);
		int age = Integer.parseInt(thisYear) - Integer.parseInt(birthDay.substring(0, 4)) + 1;
	%>
	<h2><%= birthDay %>의 나이는 <%= age %>세 입니다.</h2>
</body>
</html>