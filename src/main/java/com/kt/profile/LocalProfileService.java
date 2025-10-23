package com.kt.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("local")
@Service
public class LocalProfileService implements ProfileService {
	@Override
	public void printProfile() {
		System.out.println("local Profile Service Active.");
	}
}
