package com.kh.basicServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션으로 servlet 등록
@WebServlet(urlPatterns={"/second","/second.do"})

public class AnnotatioinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("annotation servlet 호출!");
	}
	

}
