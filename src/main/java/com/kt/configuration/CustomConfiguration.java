package com.kt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kt.user.User;

@Configuration // 스프링을 구성할때 반드시 필요해
public class CustomConfiguration {
	// @ComponentScan -> Configuration 더먼저 @Component
	// @Component 모든 클래스에
	// DI 주입을 받아서 사용하는데
	// Controller > Service > Repository
	// Service가먼저 등록되버림 repository보다

	// @Bean이라는어노테이션
	// 메서드를 Spring Bean으로 등록해주는
	@Bean
	public User user() {
		return new User();
	}
}
