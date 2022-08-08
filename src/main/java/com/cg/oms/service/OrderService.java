package com.cg.oms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.converter.OrderConverter;
import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.model.Order;
import com.cg.oms.repository.OrderRepository;
import com.cg.oms.vo.OrderVo;

/**
 * OrderService
 * @author Inam - PC
 *
 */
@Service
public class OrderService
{
	public static final String EXCEPTION_MESSAGE = "No order found with this id ";

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private OrderConverter converter;

/**
 * Get a specific order based on the given id.
 * @param id
 * @return
 * @throws OrderNotFoundException
 */
	public OrderVo getOrderById(long id) throws OrderNotFoundException
	{
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(EXCEPTION_MESSAGE + id));
		return converter.modelToVo(order);
	}
	
	/**
	 * used to place the order
	 * @param orderVo
	 * @return
	 */

	public String placeOrder(OrderVo orderVo)
	{
		Order order = converter.voToModel(orderVo);
		order = orderRepository.save(order);
		OrderVo savedVo = converter.modelToVo(order);
		return "Registered SuccessFully!!! " + savedVo.toString();
	}

	
	/**
	 * Used to cancel the order
	 * @param id
	 * @return
	 * @throws OrderNotFoundException
	 */
	

	public String cancelOrder(long id) throws OrderNotFoundException
	{
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(EXCEPTION_MESSAGE + id));
		orderRepository.delete(order);
		return "Record Deleted Successfully!!";
	}

}
