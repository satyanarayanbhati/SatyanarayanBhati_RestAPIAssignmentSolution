package com.greatlearning.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.management.entity.User;
import com.greatlearning.employee.management.service.UsersService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UsersService userService;

	@ApiOperation(value = "Add a new User", notes = "This API allows you to add a user to user table")
	@PostMapping("/add")
	public User addRole(@RequestBody User user) {
		return userService.addUser(user);
	}
}


