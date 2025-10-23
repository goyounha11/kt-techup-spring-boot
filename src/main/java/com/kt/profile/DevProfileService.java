package com.kt.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class DevProfileService implements ProfileService {
	@Override
	public void printProfile() {
		System.out.println("dev Profile Service Active.");
	}
}
