package com.greatlearning.employee.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.management.entity.Role;
import com.greatlearning.employee.management.repository.RoleRepository;
import com.greatlearning.employee.management.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role addRole(Role role) {
		roleRepository.save(role);
		roleRepository.flush();
		return role;
	}
	
}



