package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository //Autowired 될 파일이라는 표시
public class PersonDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	
	//전체 리스트 가져오기
	public List<PersonVo> personSelect(){
		System.out.println("personDao.personSelect");
		
		//DB에서 리스트 가져온다.
		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		System.out.println(personList);
		
		return personList;
	}
	
	//삭제하기
	public int personDelete (int person_id) {
		System.out.println("personDao.personDelete");
		System.out.println(person_id);
		
		int count = sqlSession.delete("phonebook.delete", person_id);
		System.out.println(count);
		return count;
	}
	
	//저장하기
	public int personInsert (PersonVo personVo) {
		System.out.println("personDao.personInsert");
		
		int count = sqlSession.insert("phonebook.insert", personVo);
		System.out.println(count);
		
		return 0;
	}
	
	//수정폼--1명 데이터 가져오기 
	public PersonVo personSelectOne(int person_id) {
		System.out.println("personDao.personSelectOne");
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectByNo", person_id);
		System.out.println(personVo);
		return personVo;
	}
	
	//수정
	public int personUpdate(PersonVo personVo) {
		System.out.println(personVo);
		
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		
		return count;
	}
	
	//Map 사용 예제
	public int personInsert2(Map<String, String> personMap) {
		System.out.println("personInsert2");
		System.out.println(personMap);
		
		int count = sqlSession.insert("phonebook.insert2", personMap);
		return count;
	}
	
	//map 사용 예제2
	public Map<String, Object> personSelectOne2(int person_id) {
		System.out.println("Dao: "+person_id);

		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectByNo2", person_id);
		System.out.println(personMap);
		// DB에서 가져오는 칼럼명을 그대로 암호로 쓰기때문에 소문자는 안됨
		System.out.println(personMap.get("PERSON_ID"));
		System.out.println(personMap.get("person_id"));
		
		return personMap;		
	}
	
	
	//resultType 예제
	public List<PersonVo> personSelect2(){
		System.out.println("personSelect2");
		
		List<PersonVo> personList = sqlSession.selectList("phonebook.select2");
		System.out.println(personList);
		
		return null;
	}
	
	

}
