package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.OrderNotFoundException;
import com.cg.model.Order;
import com.cg.service.OrderService;

@RestController
public class OrderController
{
	@Autowired
	private OrderService orderService;

	@PostMapping("/order/placeorder")
	public Order placeOrder(@RequestBody Order order)
	{
		return orderService.addOrder(order);
	}

	@DeleteMapping("order/deleteorder/{id}")
	public String deleteOrder(@PathVariable(value = "id") Long orderId) throws OrderNotFoundException
	{
		Order order = orderService.getOrderById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("No employee found with id: " + orderId));
		orderService.deleteOrder(order);
		return "Medicine " + orderId + " is deleted successfully";
	}

	@GetMapping("/order/all")
	public List<Order> listAllOrders()
	{
		return orderService.getAllOrders();
	}

	@GetMapping("/order/{id}")
	public Optional<Order> listOrderById(@PathVariable(value = "id") Long orderId) throws OrderNotFoundException
	{
		return orderService.getOrderById(orderId);
	}
}
