package com.cg.oms.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * UserEntity class
 * 
 * @author Arivazhagan
 *
 */
@Entity
@Component
@Table(name = "user_table")
public class User
{
	/**
	 * Creating Instance variables of class User
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String emailId;
	private String userName;
	private int userAge;
	private String userGender;
	private String userPhone;
	private String userPassword;
	private String previousPassword1;
	private String previousPassword2;
	private Date createdDate = new java.util.Date(new java.util.Date().getTime());
	@OneToOne(cascade = CascadeType.ALL)
	private Role role;
	@OneToOne(cascade = CascadeType.ALL)
	private Address userAddress;

	/**
	 * creating default constructors
	 * 
	 * 
	 */
	public User()
	{
		super();
	}

	/**
	 * Getter and Setter methods
	 * 
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

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getUserAge()
	{
		return userAge;
	}

	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
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

	@Override
	public String toString()
	{
		return "User [emailId=" + emailId + ", userName=" + userName + ", userAge=" + userAge + ", userGender="
				+ userGender + ", userPhone=" + userPhone + ", password=" + userPassword + ", previousPassword1="
				+ previousPassword1 + ", previousPassword2=" + previousPassword2 + ", createdDate=" + createdDate
				+ ", role=" + role + ", address=" + userAddress + "]";
	}
}