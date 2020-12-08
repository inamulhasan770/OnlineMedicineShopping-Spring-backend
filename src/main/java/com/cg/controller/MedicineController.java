package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.MedicineNotFoundException;
import com.cg.model.Medicine;
import com.cg.service.MedicineService;

@RestController
public class MedicineController
{
	@Autowired
	private MedicineService medicineService;

	@PostMapping("/Medicines/newmedicine")
	public Medicine addMedicine(@RequestBody Medicine medicine)
	{
		return medicineService.addMedicine(medicine);
	}

	@PutMapping("/Medicines/updatemedicine/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable(value = "id") Long medId,
			@RequestBody Medicine newMedicine) throws MedicineNotFoundException
	{
		Medicine oldMedicine = medicineService.getMedicineById(medId)
				.orElseThrow(() -> new MedicineNotFoundException("No medicine found with id: " + medId));
		oldMedicine.setMedicineCategory(newMedicine.getMedicineCategory());
		oldMedicine.setMedicineDescription(newMedicine.getMedicineDescription());
		oldMedicine.setMedicineExpiryDate(newMedicine.getMedicineExpiryDate());
		oldMedicine.setMedicineManufactureDate(newMedicine.getMedicineManufactureDate());
		oldMedicine.setMedicineManufacturerName(newMedicine.getMedicineManufacturerName());
		oldMedicine.setMedicineName(newMedicine.getMedicineName());
		oldMedicine.setMedicinePrice(newMedicine.getMedicinePrice());
		oldMedicine.setMedicineQuantity(newMedicine.getMedicineQuantity());
		Medicine updateMedicine = medicineService.addMedicine(oldMedicine);
		return ResponseEntity.ok(updateMedicine);
	}

	@DeleteMapping("Medicines/deletemedicine/{id}")
	public String deleteMedicine(@PathVariable(value = "id") Long medId) throws MedicineNotFoundException
	{
		Medicine medicine = medicineService.getMedicineById(medId)
				.orElseThrow(() -> new MedicineNotFoundException("No employee found with id: " + medId));
		medicineService.deleteMedicine(medicine);
		return "Medicine " + medId + " is deleted successfully";
	}

	@GetMapping("/Medicines/all")
	public List<Medicine> listAllMedicine()
	{
		return medicineService.getAllMedicine();
	}

	@GetMapping("/Medicines/id/{id}")
	public ResponseEntity<Medicine> searchById(@PathVariable(value = "id") Long medId) throws MedicineNotFoundException
	{
		Medicine medicine = medicineService.getMedicineById(medId)
				.orElseThrow(() -> new MedicineNotFoundException("No medicine found with the id: " + medId));
		return ResponseEntity.ok().body(medicine);
	}

	@GetMapping("/Medicines/medicinename/{medicinename}")
	public List<Medicine> searchByName(@PathVariable(value = "medicinename") String medName)
			throws MedicineNotFoundException
	{
		return medicineService.searchByName(medName);
	}

	@GetMapping("/Medicines/manufacturername/{manufacturername}")
	public List<Medicine> searchByManufacturer(@PathVariable(value = "manufacturername") String manufacturerName)
			throws MedicineNotFoundException
	{
		return medicineService.searchByManufacturer(manufacturerName);
	}

	@GetMapping("/Medicines/checkstock/{id}")
	public boolean checkStock(@PathVariable(value = "id") Long id) throws MedicineNotFoundException
	{
		Medicine medicine = medicineService.getMedicineById(id)
				.orElseThrow(() -> new MedicineNotFoundException("No medicine found with id: " + id));
		if (medicine.getMedicineQuantity() <= 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
