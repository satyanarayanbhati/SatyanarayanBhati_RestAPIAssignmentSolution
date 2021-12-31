package com.greatlearning.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.management.entity.Role;
import com.greatlearning.employee.management.service.RoleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	
	@ApiOperation(value = "Add Role", notes = "This API allows you to add a role to Role table")
	@PostMapping("/add")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	
}


