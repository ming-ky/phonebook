package com.javaex.phonebookv3;

import java.util.List;

/************************************************************************************************
 * verson 3 
 * 
 * - PersonView클래스 추가
 *   화면관련(사용자에게 보여지는 내용, 사용자에게서 값 받기) 기능 PersonView클래스로 분리
 *   
 *   DB관련된 기능은 PersonDao클래스가 
 *   화면관련된 기능은 PersonView클래스가 담당하도록 분리 설계
 *
 *   처리 결과에 따른 메세지는 main에서 처리 
 *************************************************************************************************/

public class MainApp {

	// 메소드- 일반
	// mian메소드
	public static void main(String[] args) {
		// 준비영역
		boolean run = true;  //반복문 탈출 변수
		
		
		//view
		PersonView personView = new PersonView();
		//dao
		PersonDao personDao = new PersonDao();
		
		
		// 시작시 안내 문구를 출력
		personView.printTitle();
		
		// while 시작
		while (run) {
			// 메뉴 출력, 입력값 리턴
			int menuNum = personView.printMenu();

			// switch() 시작
			switch (menuNum) {
			
				case 1: // 1(리스트)
					{
						//personDao를 통해 리스트를 받아온다
						List<PersonVo> personList = personDao.personSelect("");
						
						//personView를 통해 리스트를 출력한다
						personView.printList(personList);
					}	
					break;
				
				case 2: // 2(등록)
					{
						//등록폼 출력
						PersonVo personVo = personView.addForm();
						
						//입력받은 값을 dao전달 저장
						int count = personDao.personInsert(personVo);
						
						//입력 결과 메세지
						if(count>0) {
							System.out.println("[등록되었습니다.]");
						}else {
							System.out.println("[등록에 실패했습니다..]");
						}
						
					}
					break;
				
				case 3: // 3(삭제)
					{
						//삭제폼 출력
						int personId = personView.deleteForm();
						
						//입력받은 값을 dao전달 삭제
						int count = personDao.personDelete(personId);
						
						if(count>0) {
							System.out.println("[삭제되었습니다.]");
						}else {
							System.out.println("[삭제에 실패했습니다..]");
						}
					}
					break;
				
				case 4: // 4(검색)
					{
						//personView를 키워드 입력받은 화면을 출력한다
						String keyword = personView.searchForm();
						
						//personDao를 통해 리스트를 받아온다
						List<PersonVo> personList = personDao.personSelect(keyword);
						
						//personView를 통해 리스트를 출력한다
						personView.printList(personList);
					}
					break;
				
				case 5: // 5(종료)
					run = false;
					personView.printEnd();
					
					break;
	
				case 6: // 6(수정)
					{
						//수정폼 출력
						PersonVo personVo = personView.editForm();
						
						//personDao를 통해 수정한다
						int count = personDao.personUpdate(personVo);
						
						if(count>0) {
							System.out.println("[수정되었습니다.]");
						}else {
							System.out.println("[수정에 실패했습니다..]");
						}
					}	
					break;
					
				default: // 없는 번호일때
					{
						System.out.println("[다시입력해주세요]");
						System.out.println("");
					}
					break;
			}// switch() 종료
			
		} // while 종료

	}

}
