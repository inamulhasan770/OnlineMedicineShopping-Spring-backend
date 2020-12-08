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

/**
 * CartEntity class
 * 
 * @author Arivazhagan
 *
 */
@Entity

//@Table(name = "cart")
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

//	public CartEntity(MedicineEntity medicineEntity, CustomerEntity customerEntity, int quantity, float costPerPiece)
//	{
//		super();
//		this.medicineEntity = medicineEntity;
//		this.customerEntity = customerEntity;
//		this.quantity = quantity;
//		this.costPerPiece = costPerPiece;
//	}

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

	public User getCustomerEntity()
	{
		return user;
	}

	public void setCustomerEntity(User user)
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

	/**
	 * Overriding and implementing toString method to retrieve all values in the
	 * instance of CartEntity Class
	 */

//	@Override
//	public String toString()
//	{
//		return "CartEntity [cartId=" + cartId + ", medicineEntity=" + medicineEntity + ", customerEntity="
//				+ customerEntity + ", quantity=" + quantity + ", costPerPiece=" + costPerPiece + "]";
//	}

}