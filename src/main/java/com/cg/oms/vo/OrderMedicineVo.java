
package com.cg.oms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cg.oms.model.Medicine;
import com.cg.oms.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class OrderMedicineVo implements Serializable
{

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 8725207521762230972L;
	@JsonProperty(value = "order_medicine_id", access = Access.READ_ONLY)
	private long orderMedicineId;
	@JsonProperty(value = "order_id")
	private Order order;
	@JsonProperty(value = "medicine_list")
	private List<Medicine> medicineList = new ArrayList<>();
	@JsonProperty(value = "quantity")
	private int quantity;
	@JsonProperty(value = "price")
	private double price;

	
	
	/**
	 * Getters and Setters
	 * @return
	 */
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

}