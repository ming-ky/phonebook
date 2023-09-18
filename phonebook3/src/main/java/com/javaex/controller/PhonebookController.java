package com.javaex.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Get방식 요청이 들어왔을때 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 action의 값을 꺼내온다
		String action = request.getParameter("action");
		System.out.println(action);
	

		// (action.equals("list")) -- action에 null값이 오면 실행자체가 안될 수 있음
		if ("list".equals(action)) {  // -- 반대로 쓰면 "list"는 값자체이기 때문에 equals로 바로 비교가능
			System.out.println("action=list");
			// 리스트
			// 1.dao를 통해서 전체 리스트데이터 가져오기
			PersonDao personDao = new PersonDao();
			List<PersonVo> personList = personDao.personSelect("");

			System.out.println(personList);

			// 리스트 화면(html) + date 응답을 해야됨
			// request data를 넣는다
			request.setAttribute("pList", personList);

			// list.jsp 에게 시킨다 (포워드)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp"); // jsp파일 위치를 적어넣어야함
			rd.forward(request, response);
			///////////////////////////////////////////////////////////
		} else if ("wfrom".equals(action)) {
			System.out.println("action=wfrom");
			
			// writeFrom.jsp 에게 시킨다 (포워드)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeFrom.jsp"); // jsp파일 위치를 적어넣어야함
			rd.forward(request, response);
			
		} else if ("insert".equals(action)) {
			System.out.println("action=insert");
			// 저장일때
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			// 묶어주기
			PersonVo personVo = new PersonVo();
			personVo.setName(name);
			personVo.setHp(hp);
			personVo.setCompany(company);
			// DB에 요청하기
			PersonDao personDao = new PersonDao();
			personDao.personInsert(personVo);
			// 모두 처리됐으면 리스트로 돌아가기
			response.sendRedirect("./pbc?action=list");
			
		} else if ("delete".equals(action)) {
			System.out.println("action=delete");
			// 삭제일때
			int personId = Integer.parseInt(request.getParameter("id"));
			PersonDao personDao = new PersonDao();
			personDao.personDelete(personId);
			// 모두 처리됐으면 리스트로 돌아가기
			response.sendRedirect("./pbc?action=list");
			
			
		} else if ("uFrom".equals(action)) {
			// 수정폼
			System.out.println("action=uFrom");
			// 기존값들을 빼오기
			int personId = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			// 포워드로 묶은값을 업데이트폼의 html에 넣어 출력시키기
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateFrom.jsp"); // jsp파일 위치를 적어넣어야함
			rd.forward(request, response);
			
		} else if ("update".equals(action)) {
			// 수정
			System.out.println("action=update");
			int personId = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			// 수정된 값들 묶기
			PersonVo personVo = new PersonVo(personId , name, hp, company);
			// DB에 요청하기
			PersonDao personDao = new PersonDao();
			personDao.personUpdate(personVo);
			// 모두 처리됐으면 리스트로 돌아가기
			response.sendRedirect("./pbc?action=list");
			
		} else {
			System.out.println("나머지");
		}
		
		

	}

	// Post방식 요청이 들어왔을때 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
