package com.cg.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class User
{
	/**
	 * Creating Instance variable of class User
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private String password;

	private String previousPassword;

	private Date createdDate = new java.sql.Date(new java.util.Date().getTime());

	@OneToOne
	private Role role;

	@OneToOne
	private Address address;

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
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPreviousPassword()
	{
		return previousPassword;
	}

	public void setPreviousPassword(String previousPassword)
	{
		this.previousPassword = previousPassword;
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
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

}