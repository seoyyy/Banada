package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.domain.Hobby;
import com.smhrd.domain.HobbyDAO;


public class HobbyreadOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	 	String h_num = request.getParameter("h_seq");
	 	BigDecimal h_seq = new BigDecimal("h_num");
	    String h_title = request.getParameter("h_title");
	    String h_nick = request.getParameter("h_nick");
		String h_content = request.getParameter("h_content");
		int h_maxpeople = Integer.parseInt(request.getParameter("h_maxpeople"));
		int h_like = Integer.parseInt(request.getParameter("h_like"));
		
		HobbyDAO dao = new HobbyDAO();
		Hobby hobbyPost = new Hobby(h_seq, h_title, h_nick, h_content, h_maxpeople, h_like);
		hobbyPost = dao.selecthpost(hobbyPost);
		
		if(hobbyPost != null) {
			// 글 읽기 성공
			System.out.println("글 읽기 성공");
			request.setAttribute("hobbyPost", hobbyPost);
	
		} else {
			// 로그인 실패
			System.out.println("글 읽기 실패");
		
		
	}
		
	}
}


