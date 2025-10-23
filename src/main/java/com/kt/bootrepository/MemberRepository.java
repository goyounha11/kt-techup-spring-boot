package com.kt.bootrepository;

import org.springframework.stereotype.Repository;

// repository라는 의미는 데이터를 저장하고 삭제하고 조회, 수정하는 역할을 하는 클래스
// framework에서 독립적인 자바객체 (POJO, Plain Old Java Object)
// controller, service와 같은 역할을 하는 특화 어노테이션
// 어노테이션 안에 Component라는 어노테이션이 있음
// Component라는 어노테이션이 하는 일은 Spring Bean으로 등록해줘~! -> 실제로 등록 x
// 실제로 등록이 될 때는 뭔가 특별한 무언가가 있다는 것 <- Spring Boot의 엄청난 기능
// ComponentScan -> 컴포넌트스캔의 대상 범위는 어디서부터 어디까지인가요?
// spring boot application main메서드가 위치한
// 패키지 com.kt 이하의 모든 범위
//com.kt
@Repository
public class MemberRepository {
	public void save() {

	}

	public void delete() {

	}

	public void update() {

	}

	public void list() {

	}

	public void get() {

	}
}
