
package com.cg.oms.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class AddressVo implements Serializable
{
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -4067111041048561930L;
	@JsonProperty(value = "address_id", access = Access.READ_ONLY)
	private int addressId;
	@JsonProperty(value = "flat_no")
	private String flatNo;
	@JsonProperty(value = "street_name")
	private String streetName;
	@JsonProperty(value = "area")
	private String area;
	@JsonProperty(value = "city")
	private String city;
	@JsonProperty(value = "state")
	private String state;
	@JsonProperty(value = "pincode")
	private int pinCode;

	
	/**
	 * Getters and setters
	 * @return
	 */
	public int getAddressId()
	{
		return addressId;
	}

	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}

	public String getFlatNo()
	{
		return flatNo;
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

}