package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
	public List<Address> findByUser(int custId);

}
