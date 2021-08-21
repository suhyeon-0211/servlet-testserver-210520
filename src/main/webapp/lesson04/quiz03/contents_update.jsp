<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.MysqlService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// DB연결
	MysqlService mysqlService = MysqlService.getInstance();
	mysqlService.connection();
	// select 쿼리
	String selectQuery = "select * from seller";
	ResultSet result = mysqlService.select(selectQuery);
	
	
%>
<section class="contents_update">
	<h1>물건 올리기</h1>
	<form method="post" action="/lesson04/quiz03_insert">
		<div class="d-flex justify-content-between mb-3">
			<select class="form-control col-3" id="idSelect" name="sellerId">
				<option>-아이디 선택-</option>
				<%
					while(result.next()){
						
				%>
				<option value="<%= result.getInt("id") %>"><%= result.getString("nickname") %></option>
				<%
					}
				%>
			</select>
			<input type="text" class="form-control col-6" placeholder="제목" name="title" id="title">
			<div class="input-group col-2">
				<input type="text" class="form-control" placeholder="가격" name="price" id="price">
				<span class="input-group-text">원</span>
			</div>
		</div>
		<textarea rows="5" class="form-control mb-3" name="description" id="description"></textarea>
		<div class="input-group mb-3">
			<span class="input-group-text">이미지 url</span>
			<input type="text" class="form-control" name="picture">
		</div>
		<button type="button" class="btn btn-secondary w-100" id="save">저장</button>
	</form>
</section>
<script>
	$(document).ready(function() {
		$('#save').on('click', function(e) {
			let sellerId = $('#idSelect option:selected').val();
			let title = $('#title').val();
			let price = $('#price').val();
			let description = $('#description').val();
			if (sellerId == '-아이디 선택-') {
				alert("id를 선택해주세요");
				return;
			} else if (title == '') {
				alert("제목을 입력하세요");
				return;
			} else if (price == '') {
				alert("가격을 입력하세요");
				return;
			} else if (description == '') {
				alert("설명을 입력하세요");
				return;
			}
			
			if (!$.isNumeric(price)) {
				alert('가격을 숫자로 다시 입력해주세요');
				return;
			}
			
			$('#save').prop('type', 'submit');
		});
	});
	
</script>
<%
	//DB 연결 해제
	mysqlService.disconnect();
%>
