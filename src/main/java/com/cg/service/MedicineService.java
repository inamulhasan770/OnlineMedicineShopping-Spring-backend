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
	private MedicineRepository medicineRepository;

	public Medicine addMedicine(Medicine medicine)
	{
		return medicineRepository.save(medicine);
	}

	public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException
	{
		return medicineRepository.save(medicine);
	}

	public void deleteMedicine(Medicine medicine) throws MedicineNotFoundException
	{
		medicineRepository.delete(medicine);
	}

	public Optional<Medicine> getMedicineById(Long id) throws MedicineNotFoundException
	{
		return medicineRepository.findById(id);
	}

	public List<Medicine> getAllMedicine()
	{
		return medicineRepository.findAll();
	}

	public Optional<Medicine> searchById(Long id) throws MedicineNotFoundException
	{
		return medicineRepository.findById(id);
	}

	public List<Medicine> searchByName(String medName) throws MedicineNotFoundException
	{
		return medicineRepository.findByMedicineName(medName);
	}

	public List<Medicine> searchByManufacturer(String manufacturerName) throws MedicineNotFoundException
	{
		return medicineRepository.findByMedicineManufacturerName(manufacturerName);
	}

}
