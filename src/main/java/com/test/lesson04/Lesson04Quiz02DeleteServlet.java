package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet ("/lesson04/quiz02_delete")
public class Lesson04Quiz02DeleteServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 파라미터 꺼내기
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB연결
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// delete 쿼리
		String deleteQuery = "delete from url_favorites where id = " + id;
		try {
			mysqlService.update(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB연결 끊기
		mysqlService.disconnect();
		
		// 리다이렉트
		response.sendRedirect("/lesson04/quiz02/quiz02.jsp");
	}
}
