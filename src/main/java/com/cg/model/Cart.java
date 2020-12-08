package com.cg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

/**
 * CartEntity class
 * 
 * @author Arivazhagan
 *
 */
@Entity
@Component
public class Cart
{

	/**
	 * Creating Instance variables for the Admin Entity Class
	 */
	@Id
	@NotEmpty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Medicine> medicineList = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@Min(value = 1, message = "Atleast one product should be selected")
	private int quantity;

	private float costPerPiece;

	/**
	 * creating parameterized and default constructor
	 */
	public Cart()
	{
		super();
	}

	/**
	 * Creating Getter and Setter methods
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

	@Override
	public String toString()
	{
		return "Cart [cartId=" + cartId + ", medicineList=" + medicineList + ", user=" + user + ", quantity=" + quantity
				+ ", costPerPiece=" + costPerPiece + "]";
	}

	/**
	 * Overriding and implementing toString method to retrieve all values in the
	 * instance of CartEntity Class
	 */

}