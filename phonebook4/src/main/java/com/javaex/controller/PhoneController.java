package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	@Autowired
	private PersonDao personDao; // Dao 메모리에 올리기

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("리스트 출력");

		// db에서 리스트를 가져온다
		List<PersonVo> personList = personDao.personSelect();

		// ds에게 데이터 보낸다
		model.addAttribute("personList", personList);

		return "list";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("id") int person_id) {
		System.out.println("삭제 실행");

		int count = personDao.personDelete(person_id);

		System.out.println(count);

		// list.jsp에 리다이렉트 한다
		return "redirect:list";
	}

	// 등록폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("등록폼 출력");

		return "writeForm";
	}

	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("등록 실행");

		int count = personDao.personInsert(personVo);
		System.out.println(count);

		return "redirect:list";
	}

	// 수정폼
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(@RequestParam("id") int person_id, Model model) {
		System.out.println("수정폼 출력");

		// 1명데이터 가져오기
		PersonVo personVo = personDao.personSelectOne(person_id);

		// ds 포워드 시키기
		model.addAttribute("personVo", personVo);

		return "updateForm";
	}

	// 수정
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("수정 실행");

		int count = personDao.personUpdate(personVo);
		System.out.println(count);

		return "redirect:list";
	}

	// Map사용 예제
	@RequestMapping(value = "insert2", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert2(@RequestParam(value = "name") String name) {
		System.out.println("등록 2명");

		// name값은 파라미터
		// hp, company insert2()내에서 계산된 값
		String hp = "010-0000-0000";
		String company = "02-0000-0000";

		System.out.println(name);

		// 방법 1 vo로 묶는다.
		/*
		 * PersonVo personVo = new PersonVo(); personVo.setPerson_id(person_id);
		 * personVo.setHp(hp); personVo.setCompany(company);
		 */

		// 방법 2 Map을 사용한다.
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		int count = personDao.personInsert2(personMap);
		return "redirect:list";
	}

	// map사용 예제2
	@RequestMapping("/updateForm2")
	public String updateForm2(@RequestParam("id") int person_id, Model model) {
		System.out.println("수정폼2 출력");
		System.out.println("id");

		Map<String, Object> personMap = personDao.personSelectOne2(person_id);

		model.addAttribute("personMap", personMap);

		return "updateForm2";
	}

	// resultType 예제
	@RequestMapping(value = "/list2", method = { RequestMethod.GET, RequestMethod.POST })
	public String list2() {
		System.out.println("리스트2 출력");

		List<PersonVo> personList = personDao.personSelect2();

		return "";
	}

}
