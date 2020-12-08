package com.cg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderMedicine
{

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderMedicineId;

	@OneToOne(cascade = CascadeType.ALL)
	private Order order;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Medicine> medicineList = new ArrayList<>();

	private int quantity;

	private double price;

	public OrderMedicine()
	{
	}

	public long getOrderMedicineId()
	{
		return orderMedicineId;
	}

	public void setOrderMedicineId(long orderMedicineId)
	{
		this.orderMedicineId = orderMedicineId;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	public List<Medicine> getMedicineList()
	{
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList)
	{
		this.medicineList = medicineList;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "OrderMedicine [orderMedicineId=" + orderMedicineId + ", order=" + order + ", medicineList="
				+ medicineList + ", quantity=" + quantity + ", price=" + price + "]";
	}

}