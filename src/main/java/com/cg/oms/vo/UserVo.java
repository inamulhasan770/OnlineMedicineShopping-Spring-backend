package com.cg.oms.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.cg.oms.model.Address;
import com.cg.oms.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

/**
 * @author Arivazhagan
 *
 */
@Data
public class UserVo implements Serializable
{

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -7025398963426256334L;

	/**
	 * Creating Instance variables of class UserVo
	 */
	@JsonProperty(value = "user_id")
	private long userId;
	@JsonProperty(value = "email_id")
	private String emailId;
	@JsonProperty(value = "user_name")
	private String userName;
	@JsonProperty(value = "user_age")
	private int userAge;
	@JsonProperty(value = "user_gender")
	private String userGender;
	@JsonProperty(value = "user_phone")
	private String userPhone;
	@JsonProperty(value = "password", access = Access.WRITE_ONLY)
	private String userPassword;
	@JsonProperty(value = "previous_password", access = Access.WRITE_ONLY)
	private String previousPassword1;
	@JsonProperty(value = "previous_password1", access = Access.WRITE_ONLY)
	private String previousPassword2;
	@JsonProperty(value = "created_date")
	private Date createdDate = new java.util.Date(new java.util.Date().getTime());
	@JsonProperty(value = "user_role")
	@OneToOne(cascade = CascadeType.ALL)
	private Role role;
	@JsonProperty(value = "user_address")
	@OneToOne(cascade = CascadeType.ALL)
	private Address userAddress;

	/**
	 * Getters and setters methods
	 */
	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public int getUserAge()
	{
		return userAge;
	}

	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserGender()
	{
		return userGender;
	}

	public void setUserGender(String userGender)
	{
		this.userGender = userGender;
	}

	public String getUserPhone()
	{
		return userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getPreviousPassword1()
	{
		return previousPassword1;
	}

	public void setPreviousPassword1(String previousPassword1)
	{
		this.previousPassword1 = previousPassword1;
	}

	public String getPreviousPassword2()
	{
		return previousPassword2;
	}

	public void setPreviousPassword2(String previousPassword2)
	{
		this.previousPassword2 = previousPassword2;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public Address getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(Address userAddress)
	{
		this.userAddress = userAddress;
	}
}