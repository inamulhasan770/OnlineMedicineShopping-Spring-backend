package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.CartNotFoundException;
import com.cg.model.Cart;
import com.cg.service.CartService;

@RestController
public class CartController
{
	@Autowired
	private CartService cartService;

	@PostMapping("/cart/newitem")
	public Cart addItemToCart(@RequestBody Cart cart)
	{
		return cartService.addItemToCart(cart);
	}

	@DeleteMapping("cart/remove/{id}")
	public String removeCart(@PathVariable(value = "id") Long cartId) throws CartNotFoundException
	{
		Cart cart = cartService.getCartById(cartId)
				.orElseThrow(() -> new CartNotFoundException("No Cart found with id: " + cartId));
		cartService.removeCart(cart);
		return "Cart/remove";
	}

	@GetMapping("/cart/all")
	public List<Cart> listAllItems()
	{
		return cartService.getAllItems();
	}

}
