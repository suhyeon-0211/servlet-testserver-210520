package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/quiz03_insert")
public class Lesson04Quiz03Insert extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 파라미터 꺼내기
		int sellerId = Integer.parseInt(request.getParameter("sellerId"));
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String picture = request.getParameter("picture");
		
		// DB연결
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// insert 쿼리
		String insertQuery = null;
		if (picture == "") {
			insertQuery = "insert into used_goods"
					+ "(title, price, description, picture, sellerId)"
					+ "values ('" + title + "', " + price + ", '" + description + "', null, " + sellerId + ")";
		} else {
			insertQuery = "insert into used_goods"
					+ "(title, price, description, picture, sellerId)"
					+ "values ('" + title + "', " + price + ", '" + description + "', '" + picture + "', " + sellerId + ")";
		}
		try {
			mysqlService.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB연결 해제
		mysqlService.disconnect();
		
		// 리다이렉트
		response.sendRedirect("/lesson04/quiz03/template_list.jsp");
	}
}
