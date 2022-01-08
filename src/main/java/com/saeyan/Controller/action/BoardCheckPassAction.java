package com.saeyan.Controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.DAO.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;

		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		System.out.println("num : " +num);
		System.out.println("pass : " +pass);
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		System.out.println("bVo.getPass() : " + bVo.getPass());
		if (bVo.getPass().equals(pass)) {// 성공
			url = "/board/checkSuccess.jsp";
		} else {// 실패
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀립니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
