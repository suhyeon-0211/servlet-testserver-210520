package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz03")
public class UrlMappingQuiz03 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글깨짐 방지
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>quiz03</title></head><body>");
		out.print("<h1>[단독] 고양이가 야옹해</h1>");
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		out.print("<p>기사 입력 시간 : " + sdf.format(today) + "</p>");
		out.print("<hr>");
		out.print("끝");
		out.print("</body></html>");
		
	}
}
