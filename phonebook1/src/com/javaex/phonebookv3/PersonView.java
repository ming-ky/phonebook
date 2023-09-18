package com.javaex.phonebookv3;

import java.util.List;
import java.util.Scanner;

//화면 담당 클래스
public class PersonView {

	private Scanner sc;

	// 생성자: 입력을 위하여 스캐너를 생성합니다.
	public PersonView() {
		this.sc = new Scanner(System.in);
	}

	// 프로그램 시작시 안내 문구를 출력하는 메소드
	public void printTitle() {
		System.out.println("******************************************");
		System.out.println("*          전화번호 관리 프로그램             *");
		System.out.println("******************************************");
	}
	
	// 메뉴를 출력하고 메뉴번호 입력을 받아 입력된 메뉴번호를 전달하는 메소드
	public int printMenu() {
		System.out.println("");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료 *6수정");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호: ");

		int menuNum = sc.nextInt();
		sc.nextLine();

		return menuNum;

	}
	
	
	// 종료시 안내 문구를 출력하는 메소드
	public void printEnd() {
		System.out.println("");
		System.out.println("******************************************");
		System.out.println("*                   감사합니다              *");
		System.out.println("******************************************");
		
		sc.close();
	}
	

	////////////////////////////////////////////////////////////////////
	// 리스트 검색 관련
	////////////////////////////////////////////////////////////////////
	
	// 1.리스트 : 리스트결과 화면 출력
	public void printList(List<PersonVo> personList) {
		System.out.println("");
		System.out.println("<1.리스트>");

		//리스트 출력하기
		renderlist(personList);

		System.out.println("");
	}
	
	
	// 4.검색 : 검색을 위한 입력폼
	public String searchForm() {
		System.out.println("");
		System.out.println("<4.검색>");

		System.out.print(">이름: ");
		String keyword = sc.nextLine();
		System.out.print("");

		return keyword;
	}
	
	
	// 공통사용- 리스트를 화면에 출력하는 메소드 
	public void renderlist(List<PersonVo> personList) {

		for (int i = 0; i < personList.size(); i++) {
			System.out.print(personList.get(i).getPerson_id() + "\t");
			System.out.print(personList.get(i).getName() + "\t");
			System.out.print(personList.get(i).getHp() + "\t");
			System.out.print(personList.get(i).getCompany() + "\t");
			System.out.println("");
		}
	}
	
	

	////////////////////////////////////////////////////////////////////
	// 등록 관련
	////////////////////////////////////////////////////////////////////
	// 2.등록 : 등록을 위한 화면을 출력하고 사용자가 입력한 데이타를 받는다
	public PersonVo addForm() {

		System.out.println("");
		System.out.println("<2.등록>");

		System.out.print(">이름: ");
		String name = sc.nextLine();

		System.out.print(">휴대전화: ");
		String hp = sc.nextLine();

		System.out.print(">회사전화: ");
		String company = sc.nextLine();
		System.out.print("");

		PersonVo personVo = new PersonVo(name, hp, company);
		
		return personVo;

	}
	
	////////////////////////////////////////////////////////////////////
	// 삭제 관련
	////////////////////////////////////////////////////////////////////
	// 3.삭제 : 삭제를 위한 화면을 출력하고 사용자가 선택한 번호를 받는다
	public int deleteForm() {
		System.out.println("");
		System.out.println("<3.삭제>");

		System.out.print(">번호: ");
		int personId = sc.nextInt();
		sc.nextLine();
		System.out.print("");

		return personId;
	}
	
	////////////////////////////////////////////////////////////////////
	// 삭제 관련
	////////////////////////////////////////////////////////////////////
	// 6.수정 : 수정을 위한 화면을 출력하고 사용자가 입력한 데이타를 받는다
	public PersonVo editForm() {
		System.out.println("");
		System.out.println("<6.수정>");
		// 번호받기
		System.out.print(">번호: ");
		int personId = sc.nextInt();
		sc.nextLine();
		// 이름받기
		System.out.print(">이름: ");
		String name = sc.nextLine();
		// 휴대전화 받기
		System.out.print(">휴대전화: ");
		String hp = sc.nextLine();
		// 회사번호받기
		System.out.print(">회사전화: ");
		String company = sc.nextLine();

		PersonVo personVo = new PersonVo(personId, name, hp, company);

		return personVo;
	}
	
}
