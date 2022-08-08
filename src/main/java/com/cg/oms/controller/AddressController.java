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

import com.cg.oms.exception.AddressNotFoundException;
import com.cg.oms.service.AddressService;
import com.cg.oms.vo.AddressVo;

/**
 * @author ariv9
 *
 */
@RestController
public class AddressController
{
	
	/**
	 * Autowiring the service class to call down the service
	 */
	
	@Autowired
	private AddressService addressService;

	
	/**
	 * This below function is used to create a new address and redirects 
	 * to the address service
	 * @param addressVo
	 * @return
	 */
	
	
	@PostMapping("/address/addnewaddress")
	public String storeAddress(@RequestBody AddressVo addressVo)
	{
		return addressService.saveAddress(addressVo);
	}
	
	
	/**
	 * This below function is used to get all the address and redirects 
	 * to the address service
	 * @param addressVo
	 * @return
	 */
	

	@GetMapping("/address/getalladdress")
	public ResponseEntity<List<AddressVo>> getAllAddress()
	{
		List<AddressVo> addressVo = addressService.getAllAddress();
		return ResponseEntity.ok(addressVo);
	}

	
	/**
	 * This below function is used to get a specific address and id as parameter and redirects 
	 * to the address service
	 * @exception AddressNotFoundException
	 * @param addressVo
	 * @return
	 */
	
	@GetMapping("/address/getaddress/{id}")
	public ResponseEntity<AddressVo> getAddressById(@PathVariable(value = "id") long id) throws AddressNotFoundException
	{
		AddressVo addressVo = addressService.getAddressById(id);
		return ResponseEntity.ok().body(addressVo);
	}

	
	/**
	 * This below function is used to delete a specific address based on the give
	 * Id and redirects to the address service
	 * @exception AddressNotFoundException
	 * @param addressVo
	 * @return
	 */
	
	
	@DeleteMapping("/address/deleteaddress/id/{addressid}")
	public String deleteAddress(@PathVariable(value = "addressid") long addressId) throws AddressNotFoundException
	{
		return addressService.deleteAddress(addressId);
	}
	
	/**
	 * This below function is used to update a specific address based on the give
	 * Id and redirects to the address service
	 * @exception AddressNotFoundException
	 * @param addressVo
	 * @return
	 */

	@PutMapping("/address/update/{addressid}")
	public String updateAddress(@PathVariable(value = "addressid") long id, @RequestBody AddressVo addressVo)
			throws AddressNotFoundException
	{
		return addressService.updateAddress(id, addressVo);
	}
}
