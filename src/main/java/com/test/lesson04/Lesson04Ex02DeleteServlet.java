package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/ex02_delete")
public class Lesson04Ex02DeleteServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// request에서 삭제할 아이디를 꺼냄
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB 연결
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// DELETE 쿼리를 수행
		String deleteQuery = "delete from new_user where id = " + id;
		try {
			mysqlService.update(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 연결 끊기
		mysqlService.disconnect();
		
		// 목록 화면으로 이동
		response.sendRedirect("/lesson04/ex02/ex02_1.jsp");
	}
}
