package com.greatlearning.employee.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.management.entity.User;
import com.greatlearning.employee.management.repository.UserRepository;
import com.greatlearning.employee.management.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		userRepository.save(user);
		userRepository.flush();
		return user;
	}
	
	
}



