package com.cg.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

/**
 * CustomerEntity class
 * 
 * @author Muthuraja
 *
 */
@Entity
@Component
@Table(name = "user_table")
public class User
{
	/**
	 * Creating Instance variable of class User
	 */
	@Id
	@NotEmpty(message = "E-mail should not be null")
	@Email(regexp = "?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\]")
	private String emailId;

	private String userName;

	private int userAge;

	private String userGender;

	@Size(min = 0, max = 9)
	@Length(min = 10, max = 10, message = "Must be 10 digits")
	private String userPhone;

	@Pattern(regexp = "^^(?=.*[0-9])\"\r\n" + "+ \"(?=.*[a-z])(?=.*[A-Z])\"\r\n" + "+ \"(?=.*[@#$%^&+=])\"\r\n"
			+ "+ \"(?=\\\\S+$).{8,20}$\"", message = "Should match the constraints")
	@NotEmpty(message = "password should not be null")
	@Length(min = 8, max = 8)
	private String userPassword;

	private String previousPassword1;
	private String previousPassword2;

	private Date createdDate = new java.util.Date(new java.util.Date().getTime());

	@OneToOne
	private Role role;

	@OneToOne
	private Address userAddress;

	/**
	 * creating parameterized constructors
	 *
	 * 
	 * 
	 * creating default constructors
	 */
	public User()
	{
		super();
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

	public String getPassword()
	{
		return userPassword;
	}

	public void setPassword(String userPassword)
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

	public Address getAddress()
	{
		return userAddress;
	}

	public void setAddress(Address address)
	{
		this.userAddress = address;
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