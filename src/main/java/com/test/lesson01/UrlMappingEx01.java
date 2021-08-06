package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingEx01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글 깨짐 방지
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		out.println("urlmapping ex01");
		out.println("hello world!!!");
		out.println("안녕 서블릿");
		
		Date now = new Date();
		out.println(now);
		
		// formatter
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		out.println(sdf.format(now));
		
	}
}