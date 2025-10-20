package com.kt.notice;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// 서비스와 리포지토리를 연결해야 하는데,
// 방법이 뭐뭐 있더라
// 생성자 주입
// 세터 주입
// 필드 주입
@Service
@RequiredArgsConstructor
public class NoticeService {
	private final NoticeRepository noticeRepository;

	public void create() {
		System.out.println("Notice created.");
		noticeRepository.save();
	}
}
