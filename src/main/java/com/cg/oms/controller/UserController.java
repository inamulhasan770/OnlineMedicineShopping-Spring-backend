package com.cg.oms.controller;

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

import com.cg.oms.exception.UserNotFoundException;
import com.cg.oms.service.UserService;
import com.cg.oms.vo.UserVo;

/**
 * 
 * @author Arivazhagan
 *
 */
@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	/**
	 * Creates new user
	 * 
	 * @param userVo
	 * @return created user
	 */
	@PostMapping("/user/new")
	public String createUser(@RequestBody UserVo userVo)
	{
		return userService.saveUser(userVo);
	}

	/**
	 * Displays list of users.
	 * 
	 * @return all the users from the database.
	 */
	@GetMapping("/user/all")
	public ResponseEntity<List<UserVo>> getAllUser()
	{
		List<UserVo> userVo = userService.getAllUser();
		return ResponseEntity.ok(userVo);
	}

	/**
	 * 
	 * @param userId must not be null.
	 * @return user with the given id of if none found.
	 * @throws UserNotFoundException
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<UserVo> getUserById(@PathVariable(value = "id") long userId) throws UserNotFoundException
	{
		UserVo userVo = userService.getUserById(userId);
		return ResponseEntity.ok().body(userVo);
	}

	/**
	 * 
	 * @param userId must not be null.
	 * @param userVo
	 * @return updated user with the given id of if none found.
	 * @throws UserNotFoundException
	 */
	@PutMapping("/user/update/{id}")
	public String updateUser(@PathVariable(value = "id") long userId, @RequestBody UserVo userVo)
			throws UserNotFoundException
	{
		return userService.updateUser(userId, userVo);
	}

	/**
	 * 
	 * @param userId must not be null.
	 * @return deleted user with the given id of if none found then.
	 * @throws UserNotFoundException.
	 * 
	 */
	@DeleteMapping("/user/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") long userId) throws UserNotFoundException
	{
		return userService.deleteUser(userId);
	}
}