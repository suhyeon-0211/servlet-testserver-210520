package com.test.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet ("/lesson04/quiz01")
public class Lesson04Quiz01Servlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		
		// DB 연결
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// 쿼리 실행
		String insertQuery = "insert into real_estate"
							+ "(realtorId, address, area, `type`, price, rentPrice)"
							+ "values (3, '헤라펠리스 101동 5305호', 350, '매매', 1500000, null)";
//		try {
//			mysqlService.update(insertQuery);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String selectQuery = "select address, area, `type` from real_estate order by `id` limit 10";
		try {
			ResultSet result = mysqlService.select(selectQuery);
			PrintWriter out = response.getWriter();
			while (result.next()) {
				out.println("매물 주소: " + result.getString("address") + ", 면적: " + result.getInt("area") + ", 타입: " + result.getString("type"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// DB 연결 끊기
		mysqlService.disconnect();
		
	}
}
