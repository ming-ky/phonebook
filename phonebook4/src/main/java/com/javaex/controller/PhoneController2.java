package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

public class PhoneController2 {
	
	// 필드
	@Autowired  // dao 자동연결
	private PersonDao personDao;
	
	

	// 리스트 출력
	@RequestMapping("list2")
	// @RequestMapping(value="/list", method={RequestMethod.GET,RequestMethod.POST})
	// 전부 생략 가능
	public String list(Model model) {
		System.out.println("리스트 출력");
		//List<PersonVo> personList = personDao.personSelect("");

		// model 주소를 받고 메소드를 이용해서 담는다
		// --> DS request.setAttribute("암호",데이터)
		// request의 attritube에 넣는다
		//model.addAttribute("personList", personList);

		// list.jsp에 포워드 한다
		return "list";
	}

	// 등록폼 출력
	@RequestMapping(value = "writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(Model model) {
		System.out.println("등록폼 출력");

		// writeForm.jsp에 포워드 한다
		return "writeForm";
	}

	// 등록 실행(1)
//	@RequestMapping(value = "write", method = { RequestMethod.GET, RequestMethod.POST })
//	public String write(@RequestParam("name") String name,
//						@RequestParam("hp") String hp,
//						@RequestParam("company") String company ) {
//		
//		System.out.println("등록 실행");		
//				
//		PersonVo personVo = new PersonVo(name, hp, company);
//		PersonDao personDao = new PersonDao();
//		personDao.personInsert(personVo);
//
//		// list.jsp에 리다이렉트 한다
//		return "./list";
//	}
	
	// 등록 실행(2)
		@RequestMapping("write")
		public String write(@ModelAttribute PersonVo personVo) {
			System.out.println("등록 실행(2)");		
			
			//personDao.personInsert(personVo);

			// list.jsp에 리다이렉트 한다
			return "redirect:list";
		}

	// 수정폼 출력
	@RequestMapping("updateForm")
	public String updateForm(Model model,
							 @RequestParam("name") String name) {
		System.out.println("수정폼 출력");
		
		//List<PersonVo> updatePerson = personDao.personSelect(name);

		//model.addAttribute("udPerson", updatePerson);

		// updateForm.jsp에 포워드 한다
		return "updateForm";
	}

	// 수정 실행
	@RequestMapping("/update")
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("수정 실행");
	
		//personDao.personUpdate(personVo);
		
		// list.jsp에 리다이렉트 한다
		return "redirect:list";
	}

	// 삭제 실행
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int personId) {
		System.out.println("삭제 실행");
	
		//personDao.personDelete(personId);		

		// list.jsp에 리다이렉트 한다
		return "redirect:list";
	}

}