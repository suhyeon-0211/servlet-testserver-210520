package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz08")
public class GetMethodQuiz08 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		List<String> list = new ArrayList<>(Arrays.asList(
		        "강남역 최고 맛집 소개 합니다.", 
		        "오늘 기분 좋은 일이 있었네요.", 
		        "역시 맛집 데이트가 제일 좋네요.", 
		        "집에 가는 길에 동네 맛집 가서 안주 사갑니다.",
		        "자축 저 오늘 생일 이에요."));
		PrintWriter out = response.getWriter();
		String search = request.getParameter("search");
		
		out.print("<html><head><title>검색 결과</title></head><body>");
		for (String tmpList : list) {
//			if (tmpList.contains(search)) {
//				String[] tmpWords = tmpList.split(" ");
//				for (String tmp : tmpWords) {
//					if (search.equals(tmp)) {
//						out.print("<strong>" + tmp + "</strong> ");
//						continue;
//					}
//					out.print(tmp + " ");
//				}
//				out.print("<br>");
//			}
			// 풀이1
//			int index = tmpList.indexOf(search);
//			if (index > -1) {
//				StringBuffer sb = new StringBuffer(tmpList);
//				sb.insert(index, "<b>");
//				sb.insert(index + 3 + search.length(), "</b>");
//				out.print(sb + "<br>");
//			}
			
			// 풀이2
			String[] words = tmpList.split(search);
			if(tmpList.contains(search)) {
				out.print(words[0] + "<b>" + search + "</b>" + words[1] + "<br>");
			}
			
			// 풀이3
			if (tmpList.contains(search)) {
				tmpList = tmpList.replace(search, "<b>" + search + "</b>");
				out.print(tmpList + "<br>");
			}
		}
		out.print("</body></html>");
	}

}
