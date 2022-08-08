
package com.cg.oms.controller;

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

import com.cg.oms.exception.MedicineNotFoundException;
import com.cg.oms.service.MedicineService;
import com.cg.oms.vo.MedicineVo;

@RestController
public class MedicineController
{
	
	/**
	 * We are autowiring the  cart service layer to this controller layer of cart
	 * @param medicineService
	 */
	
	
	@Autowired
	private MedicineService medicineService;

	
	/**
	 * This controller is used to create a new or add new medicine
	 * and redirects it to the service layer
	 * 
	 * @param medicineVo
	 * @return
	 */
	
	
	@PostMapping("/medicine/addnewMedicine")
	public String getMedicineName(@RequestBody MedicineVo medicineVo)
	{
		return medicineService.saveMedicine(medicineVo);
	}

	/**
	 * This controller is used to return and list all the medicine found in the databasse
	 * and request to the service to perform the action
	 * 
	 * @return
	 */
	
	
	@GetMapping("/medicine/getallmedicine")
	public ResponseEntity<List<MedicineVo>> getAllMedicine()
	{
		return ResponseEntity.ok(medicineService.getAllMedicine());
	}

	
	/**
	 * This controller is used to get a specific medicine on basis of ID
	 * @param id
	 * @return
	 * @throws MedicineNotFoundException
	 */
	
	@GetMapping("/medicine/getmedicine/{id}")
	public ResponseEntity<MedicineVo> getMedicineId(@PathVariable(value = "id") long id)
			throws MedicineNotFoundException
	{
		MedicineVo medicineVo = medicineService.getMedicineById(id);
		return ResponseEntity.ok().body(medicineVo);
	}
	
	
	/**
	 * this controller is used to get a medicine on basis of given name
	 * @param medicineName
	 * @return
	 * @throws MedicineNotFoundException
	 */
	

	@GetMapping("/medicine/getmedicine/name/{medicinename}")
	public ResponseEntity<MedicineVo> getMedicineByName(@PathVariable(value = "medicinename") String medicineName)
			throws MedicineNotFoundException
	{

		return ResponseEntity.ok().body(medicineService.getMedicineByName(medicineName));
	}
	
	
	/**
	 * This controller is used to get the medicine on basis of the given manufacturer name
	 * @param manufacturerName
	 * @return
	 * @throws MedicineNotFoundException
	 */

	@GetMapping("/medicine/getmedicine/manufacturername/{manufacturername}")
	public ResponseEntity<MedicineVo> getMedicineByManufacturerName(
			@PathVariable(value = "manufacturername") String manufacturerName) throws MedicineNotFoundException
	{
		return ResponseEntity.ok().body(medicineService.getMedicineByManufacturerName(manufacturerName));
	}

	
	/**
	 * 
	 * this controller function perform deletion of a specific given medicine and
	 *  request the service to perform the action and returns the message as deleted
	 *  else throw exception
	 * @param medicineid
	 * @return
	 * @throws MedicineNotFoundException
	 */
	
	@DeleteMapping("/medicine/deletemedicine/{medicineid}")
	public String deleteMedicine(@PathVariable(value = "medicineid") long medicineid) throws MedicineNotFoundException
	{
		return medicineService.deleteMedicine(medicineid);
	}

	/**
	 * This function is used to update a specific medicine on basis of given medicine
	 * id and returns exception if given medicine id is not found.
	 * @param id
	 * @param medicineVo
	 * @return
	 * @throws MedicineNotFoundException
	 */
	
	
	@PutMapping("/medicine/updatemedicine/{id}")
	public String updateMedicine(@PathVariable(value = "id") long id, @RequestBody MedicineVo medicineVo)
			throws MedicineNotFoundException
	{
		return medicineService.updateMedicine(id, medicineVo);
	}

}