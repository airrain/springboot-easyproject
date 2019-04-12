package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;


@RestController
public class UserController {
	@Autowired
	private final UserRepository userRepository;
	
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/person/save")
	public User save(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		
		if(userRepository.save(user)) {
			System.out.printf("用户对象：%保存成功！\n",user);
			
		}
		
		return user;
	}
	
}














