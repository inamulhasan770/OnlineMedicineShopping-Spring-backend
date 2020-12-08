package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Cart;
import com.cg.repository.CartRepository;

@RestController
public class CartService
{
	@Autowired
	CartRepository cartRepo;
//	@Autowired
//	MedicineRepository medRepo;

	public Cart addItemToCart(Cart cart)
	{
		return cartRepo.save(cart);
	}

	public void removeCart(Cart cart)
	{
		cartRepo.delete(cart);
	}

	public Optional<Cart> getCartById(Long id)
	{
		return cartRepo.findById(id);
	}

	public List<Cart> getAllItems()
	{
		return cartRepo.findAll();
	}
}
