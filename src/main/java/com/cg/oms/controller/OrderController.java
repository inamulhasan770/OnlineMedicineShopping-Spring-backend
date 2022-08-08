package com.cg.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.service.OrderService;
import com.cg.oms.vo.OrderVo;

@RestController
public class OrderController
{
	
	/**
	 * We are autowiring the  order service layer to this controller layer of cart
	 * @param orderService
	 */
	
	@Autowired
	private OrderService orderService;

	
	/**
	 * This controller is used to perform place order option
	 * but this function is based on the cart table.
	 * this table is created only when the user add items to cart and send to the 
	 * Place Order option
	 * @param orderVo
	 * @return
	 */
	
	
	@PostMapping("/order/placeOrder")
	public String placeOrder(OrderVo orderVo)
	{
		return orderService.placeOrder(orderVo);
	}
	
	/**
	 * 
	 * This function is used to delete or cancel the specific order 
	 * @param id
	 * @return
	 * @throws OrderNotFoundException
	 */

	@GetMapping("/order/cancelOrder/{id}")
	public String cancelOrder(@PathVariable (value="id") long id) throws OrderNotFoundException
	{
		return orderService.cancelOrder(id);
	}

	
	/**
	 * This function is used to update a order such us quantity of the product etcc.
	 * @param orderId
	 * @return
	 * @throws OrderNotFoundException
	 */
	
	@PutMapping("/order/order/{id}")
	public ResponseEntity<OrderVo> viewOrder(@PathVariable(value = "id") long orderId) throws OrderNotFoundException
	{
		return ResponseEntity.ok().body(orderService.getOrderById(orderId));
	}


}