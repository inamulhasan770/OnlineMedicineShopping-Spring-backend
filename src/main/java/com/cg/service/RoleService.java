package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.model.Role;
import com.cg.repository.RoleRepository;

public class RoleService
{
	@Autowired
	RoleRepository roleRepository;

	public Role addRole(Role role)
	{
		return roleRepository.save(role);
	}

	public void deleteRole(Role role)
	{
		roleRepository.delete(role);
	}

	public Optional<Role> getRoleById(Long id)
	{
		return roleRepository.findById(id);
	}
}
