<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.MysqlService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// DB 연결
	MysqlService mysqlService = MysqlService.getInstance();
	mysqlService.connection();
	// select 쿼리
	String selectQuery = "select A.nickname, B.id, B.title, B.price, B.picture from seller A join used_goods B on A.id = B.sellerId";
	ResultSet result = mysqlService.select(selectQuery);
%>
<section class="contents_list d-flex flex-wrap justify-content-between">
	<%
		String image = null;
		while (result.next()) {
			if (result.getString("B.picture") == null) {
				image = "https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif";
			} else {
				image = result.getString("B.picture");
			}
	%>
	<div class="selling_product p-2 m-2">
		<img src="<%= image %>" alt="물품 사진" width="300px" height="200px"><br>
		<span class="font-weight-bold"><%= result.getString("B.title") %></span><br>
		<span class="text-secondary"><%= result.getString("B.price") %>원</span><br>
		<span class="user_id"><%= result.getString("A.nickname") %></span><br>
	</div>
	<%
		}
	%>
</section>
<%
	// DB 연결 해제
	mysqlService.disconnect();
%>