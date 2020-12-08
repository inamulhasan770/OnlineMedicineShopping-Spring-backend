package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Cart;
import com.cg.model.Medicine;

public interface CartRepository extends JpaRepository<Cart, Long>
{
	public Optional<Medicine> getMedicineById(Long id);
}
