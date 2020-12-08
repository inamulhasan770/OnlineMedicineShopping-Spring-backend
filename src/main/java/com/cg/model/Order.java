package com.cg.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Author: Srivatsan
 */
@Entity
@Table(name = "orderTable")
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

	private String Address;

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
		return Address;
	}

	public void setAddress(String address)
	{
		Address = address;
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + ", Address=" + Address
				+ "]";
	}

//	@ManyToOne
//	private List<Cart> cartList = new ArrayList<>();
	/*
	 * Creating getters and setters for above variables
	 */

}