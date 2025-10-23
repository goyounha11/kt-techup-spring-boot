package com.kt.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "kt")
public record TechupProperties(
	String techup,
	String c,
	String d
) {
}
