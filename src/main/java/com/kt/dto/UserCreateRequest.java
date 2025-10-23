package com.kt.dto;

public record UserCreateRequest(
	String loginId,
	String password,
	String name,
	int age
) {
}
