package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@PostMapping("/user/newuser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}

	@PutMapping("/user/updateuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId, @RequestBody User newUser)
			throws UserNotFoundException
	{
		User oldUser = userService.getUserById(userId)
				.orElseThrow(() -> new UserNotFoundException("No medicine found with id: " + userId));
		oldUser.setUserName(newUser.getUserName());
		oldUser.setUserAge(newUser.getUserAge());
		oldUser.setUserGender(newUser.getUserGender());
		oldUser.setPassword(newUser.getPassword());
		oldUser.setPreviousPassword1(newUser.getPreviousPassword1());
		oldUser.setPreviousPassword2(newUser.getPreviousPassword2());
		oldUser.setRole(newUser.getRole());
		oldUser.setCreatedDate(newUser.getCreatedDate());
		oldUser.setAddress(newUser.getAddress());
		User updatedUser = userService.addUser(oldUser);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("user/deleteuser/{id}")
	public String deleteUser(@PathVariable(value = "id") String userId) throws UserNotFoundException
	{
		User user = userService.getUserById(userId)
				.orElseThrow(() -> new UserNotFoundException("No employee found with id: " + userId));
		userService.deleteUser(user);
		return "User " + userId + " is deleted successfully";
	}

	@GetMapping("/user/all")
	public List<User> listAllUser()
	{
		return userService.getAllUsers();
	}

	@PutMapping("user/forgotpassword/{id}+{password}")
	public ResponseEntity<User> forgotPassword(@PathVariable(value = "id") String userId,
			@PathVariable(value = "password") String password) throws UserNotFoundException
	{
		User user = userService.getUserById(userId)
				.orElseThrow(() -> new UserNotFoundException("No employee found with id: " + userId));

		String previousPassword = user.getPassword();
		String previousPassword2 = user.getPreviousPassword1();
		user.setPassword(password);
		user.setPreviousPassword1(previousPassword);
		user.setPreviousPassword2(previousPassword2);
//		user.setRole(user.getRole());
//		user.setCreatedDate(user.getCreatedDate());
//		user.setAddress(user.getAddress());
//		user.setUserName(user.getUserName());
//		user.setUserAge(user.getUserAge());
//		user.setUserGender(user.getUserGender());
		User updatedUser = userService.addUser(user);
		return ResponseEntity.ok(updatedUser);
	}
}
