package com.cg.oms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.converter.RoleConverter;
import com.cg.oms.exception.RoleNotFoundException;
import com.cg.oms.model.Role;
import com.cg.oms.repository.RoleRepository;
import com.cg.oms.vo.RoleVo;

@Service
public class RoleService
{
	public static final String EXCEPTION_MESSAGE = "No role found with this id ";

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private RoleConverter converter;

	
	/**
	 * Used to save the role to the role table
	 * @param roleVo
	 * @return
	 */
	public String saveRole(RoleVo roleVo)
	{
		Role role = converter.voToModel(roleVo);
		role = roleRepository.save(role);
		RoleVo savedVo = converter.modelToVo(role);
		return "Registered SuccessFully!!! " + savedVo.toString();
	}
	
	/**
	 * Used to delete the role on given ID
	 * @param id
	 * @return
	 * @throws RoleNotFoundException
	 */

	public String deleteRole(long id) throws RoleNotFoundException
	{
		Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(EXCEPTION_MESSAGE + id));
		roleRepository.delete(role);
		return "Record Deleted Successfully!!";
	}
	
	/**
	 * Used to delete the role by roleID
	 * @param id
	 * @return
	 * @throws RoleNotFoundException
	 */

	public RoleVo getRoleById(long id) throws RoleNotFoundException
	{
		Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(EXCEPTION_MESSAGE + id));
		return converter.modelToVo(role);

	}

}
