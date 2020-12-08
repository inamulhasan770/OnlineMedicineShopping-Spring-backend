package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.OrderNotFoundException;
import com.cg.model.Order;
import com.cg.repository.OrderRepository;

@RestController
public class OrderService
{

	@Autowired
	private OrderRepository orderRepository;

	public Order addOrder(Order order)
	{
		return orderRepository.save(order);
	}

	public void deleteOrder(Order order) throws OrderNotFoundException
	{
		orderRepository.delete(order);
	}

	public Optional<Order> getOrderById(Long id) throws OrderNotFoundException
	{
		return orderRepository.findById(id);
	}

	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}

}