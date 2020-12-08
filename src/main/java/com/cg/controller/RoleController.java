package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.exception.RoleNotFoundException;
import com.cg.model.Role;
import com.cg.service.RoleService;

public class RoleController
{
	@Autowired
	private RoleService roleService;

	@PostMapping("/role/newrole")
	public Role addRole(@RequestBody Role role)
	{
		return roleService.addRole(role);
	}

	@DeleteMapping("role/remove/{id}")
	public String deleteRole(@PathVariable(value = "id") Long roleId) throws RoleNotFoundException
	{
		Role role = roleService.getRoleById(roleId)
				.orElseThrow(() -> new RoleNotFoundException("No Cart found with id: " + roleId));
		roleService.deleteRole(role);
		return "role/remove";
	}
}
