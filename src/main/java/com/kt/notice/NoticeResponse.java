package com.kt.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 데이터 전달을 목적으로하는 클래스 - POJO , Spring Bean -> Singleton - 딱하나
// DTO (Data Transfer Object)
// 모던 자바를 사용하는 현업에서는 record를 더 선호
// 생성자를 기반으로해서 불변객체를 생성해줌
public record NoticeResponse(
	String message
) {
}
