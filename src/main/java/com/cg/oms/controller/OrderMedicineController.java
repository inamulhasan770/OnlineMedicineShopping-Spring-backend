//OrderMedicineController
package com.cg.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.service.OrderMedicineService;
import com.cg.oms.vo.OrderMedicineVo;

@RestController
public class OrderMedicineController
{
	
	/**
	 * We are autowiring the  cart service layer to this controller layer of cart
	 * @param cartService
	 */
	
	@Autowired
	private OrderMedicineService orderMedicineService;

	/**
	 * This function is used to add new order medicine column and redirect it to the service layer
	 * @param orderMedicineVo
	 * @return
	 */
	
	
	@PostMapping("/Ordermedicine/addnew")
	public String addNewOrderMedicine(OrderMedicineVo orderMedicineVo)
	{
			return orderMedicineService.saveOrderMedicine(orderMedicineVo);
	}
	
	
	/**
	 * This controller is used to get the specific orderMedicinevalue from the given Id
	 * @param orderId
	 * @return
	 * @throws OrderNotFoundException
	 */

	@GetMapping("/OrderMedicine/{id}")
	public ResponseEntity<OrderMedicineVo> getOrderMedicineId(@PathVariable(value = "id") long orderId)
			throws OrderNotFoundException
	{
		OrderMedicineVo orderMedicineVo = orderMedicineService.getOrderMedicineById(orderId);
		return ResponseEntity.ok().body(orderMedicineVo);
	}

}