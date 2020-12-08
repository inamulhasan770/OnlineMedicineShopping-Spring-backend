package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>
{

}
