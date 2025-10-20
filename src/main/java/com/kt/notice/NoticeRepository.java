package com.kt.notice;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// Dependency Injection (DI)
// 전제조건 -> DI를 하기 위한 전제조건 -> Spring Bean으로 등록
// Spring Bean으로 등록 했다는 것은 IoC => 제어의 역전
@Repository
public class NoticeRepository {
	public void save() {
		System.out.println("Notice saved.");
	}
}
