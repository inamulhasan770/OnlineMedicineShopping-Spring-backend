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
	private MedicineService medService;

	@PostMapping("/Medicines/newmedicine")
	public Medicine addMedicine(@RequestBody Medicine medicine)
	{
		return medService.addMedicine(medicine);
	}

	@PutMapping("/Medicines/updatemedicine/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable(value = "id") Long medId,
			@RequestBody Medicine med) throws MedicineNotFoundException
	{
		Medicine medicine = medService.getMedicineById(medId)
				.orElseThrow(() -> new MedicineNotFoundException("No employee found with id: " + medId));
		medicine.setMedicineCategory(med.getMedicineCategory());
		medicine.setMedicineDescription(med.getMedicineDescription());
		medicine.setMedicineExpiryDate(med.getMedicineExpiryDate());
		medicine.setMedicineManufactureDate(med.getMedicineManufactureDate());
		medicine.setMedicineManufacturerName(med.getMedicineManufacturerName());
		medicine.setMedicineName(med.getMedicineName());
		medicine.setMedicinePrice(med.getMedicinePrice());
		medicine.setMedicineQuantity(med.getMedicineQuantity());
		Medicine updateMedicine = medService.addMedicine(medicine);
		return ResponseEntity.ok(updateMedicine);
	}

	@DeleteMapping("Medicines/deletemedicine/{id}")
	public String deleteMedicine(@PathVariable(value = "id") Long medId) throws MedicineNotFoundException
	{
		Medicine medicine = medService.getMedicineById(medId)
				.orElseThrow(() -> new MedicineNotFoundException("No employee found with id: " + medId));
		medService.deleteMedicine(medicine);
		return "Medicine " + medId + " is deleted successfully";
	}

	@GetMapping("/Medicines/all")
	public List<Medicine> listAllMedicine()
	{
		return medService.getAllMedicine();
	}

	@GetMapping("/Medicines/id/{id}")
	public ResponseEntity<Medicine> searchById(@PathVariable(value = "id") Long medId)
			throws MedicineNotFoundException
	{
		Medicine medicine = medService.getMedicineById(medId)
				.orElseThrow(() -> new MedicineNotFoundException("No medicine found with the id: " + medId));
		return ResponseEntity.ok().body(medicine);
	}

	@GetMapping("/Medicines/medicinename/{medicinename}")
	public List<Medicine> searchByName(@PathVariable(value = "medicinename") String medName)
			throws MedicineNotFoundException
	{
		return medService.searchByName(medName);
	}

	@GetMapping("/Medicines/manufacturername/{manufacturername}")
	public List<Medicine> searchByManufacturer(@PathVariable(value = "manufacturername") String manufacturerName)
			throws MedicineNotFoundException
	{
		return medService.searchByManufacturer(manufacturerName);
	}

//	@GetMapping("/Medicines/checkstock/{stock}")
//	public boolean checkStock(@PathVariable(value = "stock") int stock)
//
//	{
//		return medService.checkStock(stock);
//	}
}
