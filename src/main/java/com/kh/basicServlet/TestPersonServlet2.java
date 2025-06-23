package com.kh.basicServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPersonServlet1
 */
@WebServlet("/testPerson2.do")
public class TestPersonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestPersonServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 사용자가 입력한 값 가져오기
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String foods[] = request.getParameterValues("food");

		// 2. 업무로직
		// 사용자가 입력한 color를 바탕으로 DB서버와 연동하여 추천 음식을 조회
		String recommend = "";
		switch (color) {
		case "빨강":
			recommend = "짬뽕";
			break;
		case "노랑":
			recommend = "참외";
			break;
		case "초록":
			recommend = "시금치";
			break;
		case "파랑":
			recommend = "파워에이드";
			break;
		}

		// jsp가 화면을 만들 때 필요한 데이터들을 전달하기 위해 필요한 객체(attribute)
		request.setAttribute("recommend", recommend);

		// html 작성을 jsp에게 위임
		// 매개변수로 요청을 위임할 jsp의 경로를 추가
		RequestDispatcher dispatcher = request.getRequestDispatcher("/person/testPerson.jsp");
		dispatcher.forward(request, response); // 데이터 그대로 담아서 전송

//		// html
//		response.setContentType("text/html; charset=utf-8"); // 응답 데이터의 형식
//		PrintWriter out = response.getWriter(); // outputStream
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>개취 검사 결과</title>");
//		out.println("</head>");
//
//		out.println("<body>");
//		out.println("<h1>개인 취향조사 결과</h1>");
//		out.println("<p>" + name + "님의 개인 취향 검사 결과는</p>");
//		out.println("<p>" + color + "색을 좋아합니다.</p>");
//		out.println("<p>좋아하는 동물은 " + animal + "입니다.</p>");
//		out.println("<p>좋아하는 음식은 " + Arrays.toString(foods) + "입니다.</p>");
//		out.println("</body>");
//
//		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
