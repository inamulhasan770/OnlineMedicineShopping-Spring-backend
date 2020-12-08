package com.cg.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * Author: Srivatsan
 */
@Entity
@Component
@Table(name = "order_table")
public class Order
{

	/*
	 * Creating Instance variables for ordermodel class
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	private Date orderDate;

	private String shippingAddress;

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

	public String getAddress()
	{
		return shippingAddress;
	}

	public void setAddress(String address)
	{
		this.shippingAddress = address;
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + ", Address="
				+ shippingAddress + "]";
	}

//	@ManyToOne
//	private List<Cart> cartList = new ArrayList<>();
	/*
	 * Creating getters and setters for above variables
	 */

}