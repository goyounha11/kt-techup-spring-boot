package com.kt.bootcontroller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.user.User;

@RestController
@RequestMapping("/api/users")
// http://localhost:8080/api/users
public class UserController {
	@GetMapping
	public EntityModel<CollectionModel<User>> search() {
		var users = List.of(
			new User(1, "kt1"),
			new User(2, "kt2"),
			new User(3, "kt3"),
			new User(4, "kt4")
		);

		// 리스트를 조회했을때 어떤것이 가능하냐를 먼저 생각
		// 상세조회 - 수정, 삭제
		// 삭제

		// 생성
		var entityModel = EntityModel.of(
			CollectionModel.of(users),
			Link.of("/api/users/{id}").withRel("detail"),
			Link.of("/api/users/{id}").withTitle("삭제").withRel("delete")
		);


		return entityModel;
	}

	@GetMapping("/{id}")
	public void detail(@PathVariable Long id) {

	}

	@PostMapping
	public void create() {

	}

	@PutMapping("/{id}")
	public void update(@PathVariable Long id) {

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

	}
}
