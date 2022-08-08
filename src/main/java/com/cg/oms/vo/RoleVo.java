
package com.cg.oms.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class RoleVo implements Serializable
{
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 6452080042606681713L;

	@JsonProperty(value = "role_id", access = Access.READ_ONLY)
	private long roleId;
	@JsonProperty(value = "role_name")
	private String roleName;
	
	
	/**
	 * Getters and Setter
	 * @return
	 */

	public long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(long roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

}