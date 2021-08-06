package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/servlet/quiz05")
public class GetMethodQuiz05 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		int n = Integer.parseInt(request.getParameter("number"));
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>" + n + "단</title></head><body><ul>");
		for (int i = 1; i <= 9; i++) {
			out.print("<li>" + n + " X " + i + " = " + (n * i) + "</li>");
		}
		out.print("</ul></body></html>");
	}
}
