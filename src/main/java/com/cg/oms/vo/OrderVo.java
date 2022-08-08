
package com.cg.oms.vo;

import java.io.Serializable;
import java.util.Date;

import com.cg.oms.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class OrderVo implements Serializable
{

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 5218181055076855236L;
	@JsonProperty(value = "order_id", access = Access.READ_ONLY)
	private long orderId;
	@JsonProperty(value = "order_user")
	private User user;
	@JsonProperty(value = "order_date")
	private Date orderDate;
	@JsonProperty(value = "order_shipping_address")
	private String shippingAddress;

	
	/**
	 * Getter and Setters
	 * @return
	 */
	public long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	public String getShippingAddress()
	{
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

}