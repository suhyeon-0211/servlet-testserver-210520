package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/ex02_insert")
public class Lesson04Ex02Servlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 파라미터에서 값을 꺼낸다.
		String name = request.getParameter("name");
		String yyyymmdd = request.getParameter("yyyymmdd");
		String email = request.getParameter("email");
		String introduce = request.getParameter("introduce");
		
		// DB연결 - 싱글턴이라 한개만 생성된다.
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// 쿼리 insert
		String insertQuery = "insert into new_user (name, yyyymmdd, email, introduce)"
				+ "values ('" + name + "', '" + yyyymmdd + "', '" + email + "', '" + introduce + "')";
		try {
			mysqlService.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB연결해제
		mysqlService.disconnect();
		
		// 리다이렉트(유저 목록 화면)
		response.sendRedirect("/lesson04/ex02/ex02_1.jsp");
		
	}
}
 