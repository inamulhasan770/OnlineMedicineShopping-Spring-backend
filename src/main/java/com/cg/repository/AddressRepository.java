package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Address;
import com.cg.model.User;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
	public List<User> findCustomerById(int custId);

}
