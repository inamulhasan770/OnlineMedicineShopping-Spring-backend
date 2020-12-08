package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.repository.UserRepository;

@RestController
public class UserService
{

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user)
	{
		return userRepository.save(user);
	}

	public User updateUser(User user) throws UserNotFoundException
	{
		return userRepository.save(user);
	}

	public void deleteUser(User user) throws UserNotFoundException
	{
		userRepository.delete(user);
	}

	public Optional<User> getUserById(String id) throws UserNotFoundException
	{
		return userRepository.findById(id);
	}

	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

}
