package com.cg.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.converter.OrderMedicineConverter;
import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.model.OrderMedicine;
import com.cg.oms.repository.OrderMedicineRepository;
import com.cg.oms.vo.OrderMedicineVo;

/**
 * OrderMedicine Service
 * @author Inam - PC
 *
 */
@Service
public class OrderMedicineService
{
	public static final String EXCEPTION_MESSAGE = "No order found with this id ";

	@Autowired
	OrderMedicineRepository orderMedicineRepository;
	@Autowired
	private OrderMedicineConverter converter;

	/**
	 * Used to retrieve all the list of values from ordermedicine table
	 * @return
	 */
	
	public List<OrderMedicineVo> getAllOrderMedicine()
	{
		List<OrderMedicine> orderMedicine = orderMedicineRepository.findAll();
		return converter.modelToVo(orderMedicine);
	}
	
	/**
	 * Used to get medicineorder on basis of the given name
	 * @param id
	 * @return
	 * @throws OrderNotFoundException
	 */

	public OrderMedicineVo getOrderMedicineById(long id) throws OrderNotFoundException
	{
		OrderMedicine orderMedicine = orderMedicineRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(EXCEPTION_MESSAGE + id));
		return converter.modelToVo(orderMedicine);
	}
	
	/**
	 * Used to store the orderMedicine given from the controllerr
	 * @param vo
	 * @return
	 */

	public String saveOrderMedicine(OrderMedicineVo vo)
	{
		OrderMedicine orderMedicine = converter.voToModel(vo);
		orderMedicine = orderMedicineRepository.save(orderMedicine);
		OrderMedicineVo omvo = converter.modelToVo(orderMedicine);
		return "Cart Added SuccessFully!!! " + omvo.toString();
	}

}
