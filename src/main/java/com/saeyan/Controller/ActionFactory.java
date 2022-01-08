package com.saeyan.Controller;

import com.saeyan.Controller.action.Action;
import com.saeyan.Controller.action.BoardCheckPassAction;
import com.saeyan.Controller.action.BoardCheckPassFormAction;
import com.saeyan.Controller.action.BoardDeleteAction;
import com.saeyan.Controller.action.BoardListAction;
import com.saeyan.Controller.action.BoardUpdateAction;
import com.saeyan.Controller.action.BoardUpdateFormAction;
import com.saeyan.Controller.action.BoardViewAction;
import com.saeyan.Controller.action.BoardWriteAction;
import com.saeyan.Controller.action.BoardWriteFormAction;

public class ActionFactory {
	// 싱글톤
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() { // 외부에서 객체생성 불가
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		action = new BoardListAction(); // 추가
		System.out.println("ActionFactory : " + command);

		if (command.equals("board_list")) {
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action= new BoardViewAction();
		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
			
		return action;

	}
}
