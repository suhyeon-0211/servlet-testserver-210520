<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>템플릿 구성</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
  	<style>
  		#wrap {width: 100%; height: 1000px;}
  		header {height: 50px;}
  		nav {height: 1000px;}
  		.right {height: 1000px;}
  		.contents {height: 90%;}
  		footer {height: 10%;}
  	</style>
</head>
<body>
		<div id="wrap" class="bg-secondary">
			<header class="bg-success">
				<jsp:include page="header.jsp" />
			</header>
			<div class="d-flex">
				<nav class="bg-info col-2">
					<jsp:include page="menu.jsp" />
				</nav>
				<div class="right bg-warning col-10">
					<section class="contents bg-primary">
						<jsp:include page="content1.jsp"/>
					</section>
					<footer class="bg-danger">
						<jsp:include page="footer.jsp"/>
					</footer>
				</div>
			</div>
		</div>
</body>
</html>