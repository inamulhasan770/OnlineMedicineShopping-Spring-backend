package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.MedicineNotFoundException;
import com.cg.model.Address;
import com.cg.model.User;
import com.cg.repository.AddressRepository;

@RestController
public class AddressService
{

	@Autowired
	private AddressRepository addressRepo;
//	private CustomerRepository customerRepo;

	public Address addAddress(Address address)
	{
		return addressRepo.save(address);
	}

	public Address updateAddress(Address address) throws MedicineNotFoundException
	{

		return addressRepo.save(address);
	}

	public void deleteAddress(Address address) throws MedicineNotFoundException
	{

		addressRepo.delete(address);
	}

	public Optional<Address> getAddressById(int id) throws MedicineNotFoundException
	{
		return addressRepo.findById(id);

	}

	public List<User> getAddressByCustomerId(int id) throws MedicineNotFoundException
	{
		return addressRepo.findCustomerById(id);
	}

	public List<Address> getAllAddress()
	{
		return addressRepo.findAll();
	}
//	public List<CustomerEntity> searchAddressByCustomerId(int id) throws MedicineNotFoundException
//	{
//		return addressRepo.findCustomerById(id);
//	}

}
