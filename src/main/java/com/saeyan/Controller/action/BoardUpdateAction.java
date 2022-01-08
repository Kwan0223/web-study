package com.saeyan.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.DAO.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		System.out.println("000000000000000000000");
		System.out.println("request.getParameter(\"num\") : " +request.getParameter("num"));
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		System.out.println("000000000000000000000");
		
		new BoardListAction().execute(request, response);
		
	}

}
