package com.cg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Declare the class as entity or table
@Table(name = "Role") // Declare the table name
public class Role
{

	@Id // specifies the property, use for identity of the class
//	@Column(name = "ROLE_ID") // Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) // generates an automatic value during commit for every new entity
													// object
	private long roleId;

//	@Column(name = "ROLE_NAME")
	private String roleName;

	/*
	 * creating one to many relation with User
	 */
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<User> user = new HashSet<User>();

	public Role()
	{
		super();
	}

	// getters and setters of entity table

	public Role(String roleName)
	{
		super();
		this.roleName = roleName;
	}

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

	// Override toString() method
	@Override
	public String toString()
	{
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
