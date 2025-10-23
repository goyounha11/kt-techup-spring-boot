package com.kt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

import com.kt.configuration.TechupProperties;
import com.kt.profile.ProfileService;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {
	// 불변성을 지키기위해서 @Value가 아니라 @ConfigurationProperties + POJO
	@Value("${kt.techup}")
	private String dd;

	private final TechupProperties techupProperties;
	private final ProfileService profileService;

	public Application(TechupProperties techupProperties, ProfileService profileService) {
		this.techupProperties = techupProperties;
		this.profileService = profileService;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		// dd = "Changed Techup Value";
		// System.out.println("Application started with kt.techup = " + dd);
		//
		// System.out.println("Application started with kt.techup properties = " + techupProperties.techup());

		profileService.printProfile();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
