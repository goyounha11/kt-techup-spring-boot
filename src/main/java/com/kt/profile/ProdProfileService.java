package com.kt.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class ProdProfileService implements ProfileService {
	@Override
	public void printProfile() {
		System.out.println("prod Profile Service Active.");
	}
}
