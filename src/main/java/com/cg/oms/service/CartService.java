package com.cg.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.converter.CartConverter;
import com.cg.oms.exception.CartNotFoundException;
import com.cg.oms.model.Cart;
import com.cg.oms.repository.CartRepository;
import com.cg.oms.vo.CartVo;

/**
 * Cart Service
 * @author Inam - PC
 *
 */
@Service
public class CartService
{
	public static final String EXCEPTION_MESSAGE = "No Cart found with this id ";

	@Autowired
	CartRepository cartRepository;
	@Autowired
	private CartConverter converter;

	
	/**
	 * Get the list of all the cart
	 * @return
	 */
	public List<CartVo> getAllCart()
	{
		List<Cart> cart = cartRepository.findAll();
		return converter.modelToVo(cart);
	}
	
	/**
	 * This function will retrieve the cart on basis of given Id else throws exception
	 * @param id
	 * @return
	 * @throws CartNotFoundException
	 */

	public CartVo getCartById(long id) throws CartNotFoundException
	{
		Cart cart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(EXCEPTION_MESSAGE + id));
		return converter.modelToVo(cart);

	}

	
	/**
	 * Used to Store the cart passed as parameter from the Controller function
	 * @param cartVo
	 * @return
	 */
	public String saveCart(CartVo cartVo)
	{
		Cart cart = converter.voToModel(cartVo);
		cart = cartRepository.save(cart);
		CartVo savedVo = converter.modelToVo(cart);
		return "Cart Added SuccessFully!!! " + savedVo.toString();
	}

	
	/**
	 * Used to update Cart on based on the given Id
	 * @param id
	 * @param newCart
	 * @return
	 * @throws CartNotFoundException
	 */
	public String updateCart(long id, CartVo newCart) throws CartNotFoundException
	{
		Cart oldCart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(EXCEPTION_MESSAGE + id));
		oldCart.setCartId(newCart.getCartId());
		oldCart.setCostPerPiece(newCart.getCostPerPiece());
		oldCart.setMedicineList(newCart.getMedicineList());
		oldCart.setQuantity(newCart.getQuantity());
		oldCart.setUser(newCart.getUser());
		Cart updatedCart = cartRepository.save(oldCart);
		CartVo savedVo = converter.modelToVo(updatedCart);
		return "Updated successfully" + savedVo.toString();
	}

	/**
	 * used to delete the cart based on the given ID
	 * @param id
	 * @return
	 * @throws CartNotFoundException
	 */
	
	public String deleteCart(long id) throws CartNotFoundException
	{
		Cart cart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(EXCEPTION_MESSAGE + id));
		cartRepository.delete(cart);
		return "Record Deleted Successfully!!";
	}

}
