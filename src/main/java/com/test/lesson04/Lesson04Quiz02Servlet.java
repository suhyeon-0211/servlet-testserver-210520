package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.test.common.MysqlService;

@WebServlet ("/lesson04/quiz02_insert")
public class Lesson04Quiz02Servlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 파라미터 꺼내오기
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		// DB 연결
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// insert 쿼리
		String insertQuery = "insert into url_favorites (name, url) values ('" + name + "', '" + url + "')";
		try {
			mysqlService.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 연결 끊기
		mysqlService.disconnect();
		
		// 리다이렉트
		response.sendRedirect("/lesson04/quiz02/quiz02.jsp");
	}
}
