
package com.cg.oms.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class MedicineVo implements Serializable
{
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7150266644906337644L;
	@JsonProperty(value = "medicine_id", access = Access.READ_ONLY)
	private long medicineId;
	@JsonProperty(value = "medicine_name")
	private String medicineName;
	@JsonProperty(value = "medicine_category")
	private String medicineCategory;
	@JsonProperty(value = "medicine_description")
	private String medicineDescription;
	@JsonProperty(value = "medicine_price")
	private double medicinePrice;
	@JsonProperty(value = "medicine_manfacturer_name")
	private String medicineManufacturerName;
	@JsonProperty(value = "medicine_manufacturer_date")
	private Date medicineManufacturerDate;
	@JsonProperty(value = "medicine_expiry_date")
	private Date medicineExpiryDate;
	@JsonProperty(value = "medicine_quantity")
	private int medicineQuantity;

	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public long getMedicineId()
	{
		return medicineId;
	}

	public void setMedicineId(long medicineId)
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

	public Date getMedicineManufacturerDate()
	{
		return medicineManufacturerDate;
	}

	public void setMedicineManufacturerDate(Date medicineManufacturerDate)
	{
		this.medicineManufacturerDate = medicineManufacturerDate;
	}

	public Date getMedicineExpiryDate()
	{
		return medicineExpiryDate;
	}

	public void setMedicineExpiryDate(Date medicineExpiryDate)
	{
		this.medicineExpiryDate = medicineExpiryDate;
	}

	public int getMedicineQuantity()
	{
		return medicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity)
	{
		this.medicineQuantity = medicineQuantity;

	}

}