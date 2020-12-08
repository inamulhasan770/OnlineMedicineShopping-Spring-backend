package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.MedicineNotFoundException;
import com.cg.model.Medicine;
import com.cg.repository.MedicineRepository;

@RestController
public class MedicineService
{

	@Autowired
	private MedicineRepository medRepo;

	public Medicine addMedicine(Medicine medicine)
	{
		return medRepo.save(medicine);
	}

	public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException
	{

		return medRepo.save(medicine);
	}

	public void deleteMedicine(Medicine medicine) throws MedicineNotFoundException
	{

		medRepo.delete(medicine);
	}

	public Optional<Medicine> getMedicineById(Long id) throws MedicineNotFoundException
	{
		return medRepo.findById(id);

	}

	public List<Medicine> getAllMedicine()
	{
		return medRepo.findAll();
	}

	public Optional<Medicine> searchById(Long id) throws MedicineNotFoundException
	{
		return medRepo.findById(id);

	}

	public List<Medicine> searchByName(String medName) throws MedicineNotFoundException
	{
		return medRepo.findByMedicineName(medName);
	}

	public List<Medicine> searchByManufacturer(String manufacturerName) throws MedicineNotFoundException
	{
		return medRepo.findByMedicineManufacturerName(manufacturerName);
	}

//	public boolean checkStockByMedicineName(String medName)
//	{
//		return medRepo.(medName);
//	}
}
