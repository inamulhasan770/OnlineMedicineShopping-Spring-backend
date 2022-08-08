package com.cg.oms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * AddressEntity class
 * 
 * @author
 *
 */

@Entity
@Component
public class Address
{
	/**
	 * creating instance variables for the class AddressEntity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private String flatNo;
	private String streetName;
	private String area;
	private String city;
	private String state;
	private int pinCode;

	/**
	 * creating default constructors
	 */
	public Address()
	{
		super();
	}

	/**
	 * creating getters and setters for AdminEntity class
	 */

	public String getFlatNo()
	{
		return flatNo;
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

	/**
	 * Implementing and overriding toString to retrieve all values in the instance
	 * of Address Class
	 */
	@Override
	public String toString()
	{
		return "Address [ " + flatNo + "\t" + streetName + "\t" + area + "\t" + city + "\t" + state + "\t" + pinCode
				+ "\t" + "\t ]";
	}
}