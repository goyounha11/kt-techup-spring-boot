package com.kt.factory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kt.bootservice.AdminNoticeService;
import com.kt.bootservice.NormalNoticeService;
import com.kt.bootservice.NoticeService;
import com.kt.bootservice.UserNoticeService;

@Configuration
public class NoticeServiceSelectFactory {
	@Bean
	@ConditionalOnProperty(prefix = "notice", name = "type", havingValue = "user")
	public NoticeService userNoticeService1() {
		return new UserNoticeService();
	}

	@Bean
	@ConditionalOnProperty(prefix = "notice", name = "type", havingValue = "admin")
	public NoticeService adminNoticeService1() {
		return new AdminNoticeService();
	}

	@Bean
	@ConditionalOnProperty(prefix = "notice", name = "type", havingValue = "normal")
	public NoticeService normalNoticeService() {
		return new NormalNoticeService();
	}
}
