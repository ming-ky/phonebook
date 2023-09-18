package com.javaex.phonebookv2;

import java.util.List;
import java.util.Scanner;

/************************************************************************************************
 * verson 2 
 * 
 * - 리스트 와 검색 메뉴선택시 1개의 메소드로 통일 
 *   PersonDao.personSelect(), PersonDao.personSelect(String keyword) 한개로 통합 
 * 
 * - MainApp의 출력 영역을 listPrint(List<PersonVo> personList) 메소드로 만들어서 공통사용
 * 
 * - 메소드에 데이터 전달시 vo로 묶어서 전달  
 *   personDao.personInsert(name, hp, company) ==> personDao.personInsert(personVo)
 *************************************************************************************************/

public class MainApp {

	// 메소드- 일반
	// mian메소드
	public static void main(String[] args) {
		// 준비영역
		boolean run = true;  //반복문 탈출 변수
		
		//dao
		PersonDao personDao = new PersonDao();
		
		// 스캐너
		Scanner sc = new Scanner(System.in);

		// 시작화면 출력
		System.out.println("******************************************");
		System.out.println("*          전화번호 관리 프로그램        *");
		System.out.println("******************************************");

		// while 시작 -종료메뉴 선택할때까지 반복
		while (run) {
			// 메뉴 출력
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료  *6.수정");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호: ");

			// 메뉴 입력
			int menuNum = sc.nextInt();
			sc.nextLine();

			// switch() 시작
			switch (menuNum) {

				// 1(리스트)
				case 1:
					{	System.out.println("<1.리스트>");
						
						//Dao를 통해 리스트를 가져온다
						List<PersonVo> personList = personDao.personSelect("");
						
						//출력한다  아래의 출력 메소드사용************************************************
						listPrint(personList);
						
					}
					break;
					
				// 2(등록)
				case 2:
					{	System.out.println("<2.등록>");
						// 이름받기
						System.out.print(">이름: ");
						String name = sc.nextLine();
						// 휴대전화 받기
						System.out.print(">휴대전화: ");
						String hp = sc.nextLine();
						// 회사번호받기
						System.out.print(">회사전화: ");
						String company = sc.nextLine();
		
						//입력받은 데이터를 vo로 묶는다,  생성자 추가했음
						PersonVo personVo = new PersonVo(name, hp, company);
						
						//Dao를 통해 저장한다
						int count = personDao.personInsert(personVo);
						if(count >0 ) {
							System.out.println("[등록되었습니다.]");
						}else {
							System.out.println("[등록에 실패했습니다.]");
						}
					}	
					break;
					
				// 3(삭제)
				case 3:
					{	System.out.println("<3.삭제>");
						System.out.print(">번호 : ");
						int personId= sc.nextInt();
						
						//Dao를 통해 삭제한다
						int count = personDao.personDelete(personId);
						if(count >0 ) {
							System.out.println("[삭제되었습니다.]");
						}else {
							System.out.println("[삭제에 실패했습니다.]");
						}
					}
					break;
					
				// 4(검색)
				case 4:
					{	System.out.println("<4.검색>");
						System.out.print(">이름: ");
						String keyword = sc.nextLine();
						
						//Dao를 통해 검색된 리스트를 가져온다
						List<PersonVo> personList = personDao.personSelect(keyword);
						
						//출력한다  아래의 출력 메소드사용************************************************
						listPrint(personList);
						
					}
					break;
					
				// 5(종료)
				case 5:
					run = false;
					break;
	
				case 6: //수정
					{
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
						
						//Dao를 통해 수정한다
						int count = personDao.personUpdate(personVo);
						if(count >0 ) {
							System.out.println("[수정되었습니다.]");
						}else {
							System.out.println("[수정에 실패했습니다.]");
						}
					}	
					break;	
					
				// 없는 번호일때
				default:
					System.out.println("[다시 입력해 주세요.]");
					break;

			}// switch() 종료

		} // while 종료

		sc.close();
		
		// 종료화면
		System.out.println("");
		System.out.println("******************************************");
		System.out.println("*                   감사합니다           *");
		System.out.println("******************************************");
	}

	// 출력메소드 
	// 리스트출력, 검색후리스트출력 공통사용
	public static void listPrint(List<PersonVo> personList) {

		for (int i = 0; i < personList.size(); i++) {
			System.out.print(personList.get(i).getPerson_id() + "\t");
			System.out.print(personList.get(i).getName() + "\t");
			System.out.print(personList.get(i).getHp() + "\t");
			System.out.print(personList.get(i).getCompany() + "\t");
			System.out.println("");
		}
	}

}
