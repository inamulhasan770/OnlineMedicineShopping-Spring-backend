package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

/**
 * AddressEntity class
 * 
 * @author Muthuraja
 *
 */

@Entity
@Component
//@Table(name = "Address")
public class Address
{
	/**
	 * creating instance variables for the class AddressEntity
	 */
	@Id
//	@Column(name = "address_id")
	private int addressId;
//	@Column(name = "flat_no")
	private String flatNo;
//	@Column(name = "street_name")
	private String streetName;
//	@Column(name = "area")
	private String area;
//	@Column(name = "city")
	private String city;
//	@Column(name = "state")
	private String state;
//	@Column(name = "pin_code")
	private int pinCode;

	@OneToOne(mappedBy = "address")
	private User user;

	/**
	 * creating parameterized constructors
	 *
	 * 
	 * 
	 * creating default constructors
	 */
	public Address()
	{
		super();
	}

//	public AddressEntity(int addressId, String flatNo, String streetName, String area, String city, String state,
//			int pinCode, String addressType, CustomerEntity customerEntity)
//	{
//		super();
//		this.addressId = addressId;
//		this.flatNo = flatNo;
//		this.streetName = streetName;
//		this.area = area;
//		this.city = city;
//		this.state = state;
//		this.pinCode = pinCode;
//		this.addressType = addressType;
//		this.customerEntity = customerEntity;
//	}
//
//	public AddressEntity(String flatNo, String streetName, String area, String city, String state, int pinCode,
//			String addressType, CustomerEntity customerEntity)
//	{
//		super();
//		this.flatNo = flatNo;
//		this.streetName = streetName;
//		this.area = area;
//		this.city = city;
//		this.state = state;
//		this.pinCode = pinCode;
//		this.addressType = addressType;
//		this.customerEntity = customerEntity;
//	}

	/**
	 * creating getters and setters for AdminEntity class
	 */

	public String getFlatNo()
	{
		return flatNo;
	}

	public User getCustomerEntity()
	{
		return user;
	}

	public void setCustomerEntity(User user)
	{
		this.user = user;
	}

	public int getAddressId()
	{
		return addressId;
	}

	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}

	public void setFlatNo(String flatNo)
	{
		this.flatNo = flatNo;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getPinCode()
	{
		return pinCode;
	}

	public void setPinCode(int pinCode)
	{
		this.pinCode = pinCode;
	}

	@Override
	public String toString()
	{
		return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", streetName=" + streetName + ", area="
				+ area + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + ", user=" + user + "]";
	}

	/**
	 * Implementing toString to retrieve all values in the instance of AdminEntity
	 * Class
	 */

//	@Override
//	public String toString()
//	{
//		return "AddressEntity [flatNo=" + flatNo + ", streetName=" + streetName + ", area=" + area + ", city=" + city
//				+ ", state=" + state + ", pinCode=" + pinCode + "]";
//	}

}