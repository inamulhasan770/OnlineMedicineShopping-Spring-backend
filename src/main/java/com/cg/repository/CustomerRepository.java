package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.User;

public interface CustomerRepository extends JpaRepository<User, Integer>
{
	public List<User> findByCustomerID(int custId);

}
