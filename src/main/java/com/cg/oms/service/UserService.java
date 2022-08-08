package com.cg.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.converter.UserConverter;
import com.cg.oms.exception.UserNotFoundException;
import com.cg.oms.model.User;
import com.cg.oms.repository.UserRepository;
import com.cg.oms.vo.UserVo;

/**
 * 
 * @author Arivazhagan
 *
 */
@Service
public class UserService
{

	public static final String EXCEPTION_MESSAGE = "No user found with this id ";

	@Autowired
	UserRepository userRepository;
	@Autowired
	private UserConverter converter;

	/**
	 * Displays List of users.
	 * 
	 * @return all users.
	 */
	public List<UserVo> getAllUser()
	{
		List<User> user = userRepository.findAll();
		return converter.modelToVo(user);
	}

	/**
	 * 
	 * @param userId must not be null.
	 * @return the user with the given id or if none found.
	 * @throws UserNotFoundException.
	 * 
	 */
	public UserVo getUserById(long userId) throws UserNotFoundException
	{
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(EXCEPTION_MESSAGE + userId));
		return converter.modelToVo(user);
	}

	/**
	 * 
	 * @param userVo object from UserVo model.
	 * @return saved user.
	 */
	public String saveUser(UserVo userVo)
	{
		User user = converter.voToModel(userVo);
		user = userRepository.save(user);
		UserVo savedVo = converter.modelToVo(user);
		return "Registered SuccessFully!!! " + savedVo.toString();
	}

	/**
	 * 
	 * @param id       must not be null.
	 * @param newRole.
	 * @return updated user with given id or if none found.
	 * @throws UserNotFoundException.
	 */
	public String updateUser(long id, UserVo newRole) throws UserNotFoundException
	{
		User oldUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(EXCEPTION_MESSAGE + id));
		oldUser.setEmailId(newRole.getEmailId());
		oldUser.setUserName(newRole.getUserName());
		oldUser.setUserGender(newRole.getUserGender());
		oldUser.setUserPhone(newRole.getUserPhone());
		oldUser.setUserAge(newRole.getUserAge());
		oldUser.setUserPassword(newRole.getUserPassword());
		oldUser.setPreviousPassword1(newRole.getPreviousPassword1());
		oldUser.setPreviousPassword2(newRole.getPreviousPassword2());
		oldUser.setRole(newRole.getRole());
		oldUser.setCreatedDate(newRole.getCreatedDate());
		oldUser.setUserAddress(newRole.getUserAddress());
		User updatedUser = userRepository.save(oldUser);
		UserVo savedVo = converter.modelToVo(updatedUser);
		return "User updated successfully" + savedVo.toString();
	}

	/**
	 * 
	 * @param userId must not be null.
	 * @return deleted user or if none found.
	 * @throws UserNotFoundException.
	 */
	public String deleteUser(long userId) throws UserNotFoundException
	{
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(EXCEPTION_MESSAGE + userId));
		userRepository.delete(user);
		return "Record Deleted Successfully!!";
	}
}
