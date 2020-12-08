package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>
{
	public List<Medicine> findByMedicineName(String medName);

	public List<Medicine> findByMedicineManufacturerName(String medName);
}
