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

import com.cg.exception.AddressNotFoundException;
import com.cg.model.Address;
import com.cg.service.AddressService;

@RestController
public class AddressController
{
	@Autowired
	private AddressService addressService;

	@PostMapping("/address/newaddress")
	public Address addAddress(@RequestBody Address address)
	{
		return addressService.addAddress(address);
	}

	@PutMapping("/address/updateaddress/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") int addrId, @RequestBody Address addr)
			throws AddressNotFoundException
	{
		Address address = addressService.getAddressById(addrId)
				.orElseThrow(() -> new AddressNotFoundException("No Address found with id: " + addrId));
		address.setAddressId(addr.getAddressId());
		address.setArea(addr.getArea());
		address.setCity(addr.getCity());
		address.setPinCode(addr.getPinCode());
		address.setState(addr.getState());
		address.setStreetName(addr.getStreetName());
		address.setCustomerEntity(addr.getCustomerEntity());
		Address updateAddress = addressService.addAddress(address);
		return ResponseEntity.ok(updateAddress);
	}

	@DeleteMapping("address/deleteaddress/{id}")
	public String deleteAddress(@PathVariable(value = "id") int addrId) throws AddressNotFoundException
	{
		Address address = addressService.getAddressById(addrId)
				.orElseThrow(() -> new AddressNotFoundException("No address found with id: " + addrId));
		addressService.deleteAddress(address);
		return "Address " + addrId + " is deleted successfully";
	}

	@GetMapping("/address/all")
	public List<Address> listAllAddress()
	{
		return addressService.getAllAddress();
	}

//	@GetMapping("/address/id/{id}")
//	public ResponseEntity<AddressEntity> searchAddressByCustomerId(@PathVariable(value = "id") int custId)
//			throws MedicineNotFoundException
//	{
//		AddressEntity addressEntity = addrService.getAddressByCustomerId(custId).orElseThrow(
//				() -> new MedicineNotFoundException("No address found with for the customer id: " + custId));
//		return ResponseEntity.ok().body(addressEntity);
//	}

}
