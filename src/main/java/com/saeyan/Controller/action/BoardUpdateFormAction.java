package com.saeyan.Controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.DAO.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String url ="/board/boardUpdate.jsp";
	 
	 String num = request.getParameter("num");
	 
	 BoardDAO bDao = BoardDAO.getInstance();
	 
	 bDao.updateReadCount(num);
	 
	 BoardVO bVo = bDao.selectOneBoardByNum(num);
	
	 
	 request.setAttribute("board", bVo);
	 
	 RequestDispatcher dis = request.getRequestDispatcher(url);
	 dis.forward(request, response);
	 
		
	}

}
