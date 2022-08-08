package com.cg.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.exception.CartNotFoundException;
import com.cg.oms.service.CartService;
import com.cg.oms.vo.CartVo;

@RestController
public class CartController
{
	
	
	/**
	 * We are autowiring the  cart service layer to this controller layer of cart
	 * @param cartService
	 */
	
	@Autowired
	private CartService cartService;

	
	/**
	 * This below function is used to create a new cart and redirects to the CartService
	 * @param CartVo
	 * @return
	 */
	
	
	@PostMapping("/cart/newcart")
	public String addCart(@RequestBody CartVo cartVo)
	{
		return cartService.saveCart(cartVo);
	}

	
	/**
	 * This below function is used to get a specific cart based on the 
	 * given ID and redirects to the CartService
	 * @exception CartNotFoundException
	 * @param CartVo
	 * @return
	 */
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<CartVo> getCartId(@PathVariable(value = "id") long cartId) throws CartNotFoundException
	{
		CartVo cartVo = cartService.getCartById(cartId);
		return ResponseEntity.ok().body(cartVo);
	}
	
	
	/**
	 * This below function is used to delete cart and redirects to the CartService
	 * @exception CartNotFoundException
	 * @param CartVo
	 * @return
	 */

	@DeleteMapping("/cart/cancelorder/{cartid}")
	public String deleteCart(@PathVariable(value = "cartid") long cartId) throws CartNotFoundException
	{
		return cartService.deleteCart(cartId);
	}
}
