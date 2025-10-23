package com.kt.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("real")
@Service
public class RealProfileService implements ProfileService {
	@Override
	public void printProfile() {
		System.out.println("real Profile Service Active.");
	}
}

// 우리가 AI서비스를 연동 완료
// 잘되나 하고 테스트 코드 하루에 무조건 10번이상을 돌림
// ai서비스에 실제로 요청이나감 -> Profile
// localAiService -> 응답을 가짜로 설정
// defaultAiService -> profile dev, prod
// 끊어버림
