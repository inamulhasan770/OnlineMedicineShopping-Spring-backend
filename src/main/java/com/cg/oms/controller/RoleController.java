package com.cg.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.exception.RoleNotFoundException;
import com.cg.oms.service.RoleService;
import com.cg.oms.vo.RoleVo;

@RestController
public class RoleController
{
	/**
	 * We are autowiring the  role service layer to this controller layer of cart
	 * @param roleService
	 */
	
	
	@Autowired
	private RoleService roleService;

	/**
	 * This function is used to create a new role. and it redirects to the role service
	 * @param roleVo
	 * @return
	 */
	
	
	@PostMapping("/role/newrole")
	public String roleName(@RequestBody RoleVo roleVo)
	{
		return roleService.saveRole(roleVo);
	}

	
	/**
	 * This function is used to get the role using the primary key column
	 * @param id
	 * @return
	 * @throws RoleNotFoundException
	 */
	
	@GetMapping("/role/getroleId/{id}")
	public ResponseEntity<RoleVo> getRoleId(@PathVariable(value = "id") long id) throws RoleNotFoundException
	{
		RoleVo roleVo = roleService.getRoleById(id);
		return ResponseEntity.ok().body(roleVo);
	}
	
	/**
	 * This function is used to delete the specific role.
	 * It the User of that role is deleted that will cascade delete this column also
	 * @param roleId
	 * @return
	 * @throws RoleNotFoundException
	 */

	@DeleteMapping("/role/deleterole/{roleId}")
	public String deleteRole(@PathVariable(value = "roleId") long roleId) throws RoleNotFoundException
	{
		return roleService.deleteRole(roleId);
	}

}