package com.kt.bootservice;

import org.springframework.stereotype.Service;

// @Service
public class UserNoticeService implements NoticeService {
	@Override
	public void create() {
		System.out.println("User Notice created.");
	}
}
