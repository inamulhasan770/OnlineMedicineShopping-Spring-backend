
package com.cg.oms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cg.oms.model.Medicine;
import com.cg.oms.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class CartVo implements Serializable
{
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1708373541579982421L;
	@JsonProperty(value = "cart_id", access = Access.READ_ONLY)
	private long cartId;
	@JsonProperty(value = "medicine_list")
	private List<Medicine> medicineList = new ArrayList<>();
	@JsonProperty(value = "user")
	private User user;
	@JsonProperty(value = "quantity")
	private int quantity;
	@JsonProperty(value = "cost_per_price")
	private float costPerPiece;

	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public long getCartId()
	{
		return cartId;
	}

	public void setCartId(long cartId)
	{
		this.cartId = cartId;
	}

	public List<Medicine> getMedicineList()
	{
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList)
	{
		this.medicineList = medicineList;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public float getCostPerPiece()
	{
		return costPerPiece;
	}

	public void setCostPerPiece(float costPerPiece)
	{
		this.costPerPiece = costPerPiece;
	}

}