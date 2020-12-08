package com.cg.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * Medicine POJO class
 * 
 * @author Saranish
 *
 */
@Entity
//@Table(name = "medicine")
@Component
public class Medicine
{
	/**
	 * Creating Instance variables for MedicineEntity class
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name = "id")
	private Long medicineId;
//	@Column(name = "medicine_name")
	private String medicineName;
//	@Column(name = "medicine_category")
	private String medicineCategory;
////	@Column(name = "medicine_description")
	private String medicineDescription;
////	@Column(name = "medicine_price")
	private double medicinePrice;
////	@Column(name = "medicine_manufacturer_name")
	private String medicineManufacturerName;
////	@Column(name = "medicine_manufacture_date")
	private Date medicineManufactureDate;
////	@Column(name = "medicine_expiry_date")
	private Date medicineExpiryDate;
////	@Column(name = "medicine_quality")

	private int medicineQuantity;

	/**
	 * creating parameterized constructors
	 *
	 * 
	 * 
	 * creating default constructors
	 */
	public Medicine()
	{
		super();
	}

//	public MedicineEntity(int medicineID, String medicineName, String medicineCategory, String medicineDescription,
//			double medicinePrice, String medicineManufacturerName, String medicineManufactureDate,
//			String medicineExpiryDate, int medicineQuantity)
//	{
//		super();
//		this.medicineID = medicineID;
//		this.medicineName = medicineName;
//		this.medicineCategory = medicineCategory;
//		this.medicineDescription = medicineDescription;
//		this.medicinePrice = medicinePrice;
//		this.medicineManufacturerName = medicineManufacturerName;
//		this.medicineManufactureDate = medicineManufactureDate;
//		this.medicineExpiryDate = medicineExpiryDate;
//		this.medicineQuantity = medicineQuantity;
//	}
//

	/**
	 * Creating setter and getter methods
	 */
	public Long getMedicineId()
	{
		return medicineId;
	}

	public void setMedicineId(Long medicineId)
	{
		this.medicineId = medicineId;
	}

	public String getMedicineName()
	{
		return medicineName;
	}

	public void setMedicineName(String medicineName)
	{
		this.medicineName = medicineName;
	}

	public String getMedicineCategory()
	{
		return medicineCategory;
	}

	public void setMedicineCategory(String medicineCategory)
	{
		this.medicineCategory = medicineCategory;
	}

	public String getMedicineDescription()
	{
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription)
	{
		this.medicineDescription = medicineDescription;
	}

	public double getMedicinePrice()
	{
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice)
	{
		this.medicinePrice = medicinePrice;
	}

	public String getMedicineManufacturerName()
	{
		return medicineManufacturerName;
	}

	public void setMedicineManufacturerName(String medicineManufacturerName)
	{
		this.medicineManufacturerName = medicineManufacturerName;
	}

	public Date getMedicineManufactureDate()
	{
		return medicineManufactureDate;
	}

	public void setMedicineManufactureDate(Date medicineManufactureDate)
	{
		this.medicineManufactureDate = medicineManufactureDate;
	}

	public Date getMedicineExpiryDate()
	{
		return medicineExpiryDate;
	}

	public void setMedicineExpiryDate(Date medicineExpiryDate)
	{
		this.medicineExpiryDate = medicineExpiryDate;
	}

	public void setMedicineQuantity(int medicineQuantity)
	{
		this.medicineQuantity = medicineQuantity;
	}

	public Integer getMedicineQuantity()
	{
		return medicineQuantity;
	}

	public void setMedicineQuantity(Integer medicineQuantity)
	{
		this.medicineQuantity = medicineQuantity;
	}

	@Override
	public String toString()
	{
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCategory="
				+ medicineCategory + ", medicineDescription=" + medicineDescription + ", medicinePrice=" + medicinePrice
				+ ", medicineManufacturerName=" + medicineManufacturerName + ", medicineManufactureDate="
				+ medicineManufactureDate + ", medicineExpiryDate=" + medicineExpiryDate + ", medicineQuantity="
				+ medicineQuantity + "]";
	}

	/**
	 * Implementing and overriding toString method to retrieve all values in the
	 * instance of Medicine Class
	 */

//	@Override
//	public String toString()
//	{
//		return "MedicineEntity [medicineID=" + medicineID + ", medicineName=" + medicineName + ", medicineCategory="
//				+ medicineCategory + ", medicineDescription=" + medicineDescription + ", medicinePrice=" + medicinePrice
//				+ ", medicineManufacturerName=" + medicineManufacturerName + ", medicineManufactureDate="
//				+ medicineManufactureDate + ", medicineExpiryDate=" + medicineExpiryDate + ", medicineQuantity="
//				+ medicineQuantity + "]";
//	}

}