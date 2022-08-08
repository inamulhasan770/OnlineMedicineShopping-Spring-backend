package com.cg.oms.exception;

/**
 * Class CartNotFoundException extends {@link java.lang.Exception}
 * @author Inam - PC
 *
 */

public class CartNotFoundException extends Exception
{

	/**
	 * Generated serialVersioUID
	 */
	private static final long serialVersionUID = -2903268500100321707L;

	
	
	/**
	 * Parameterized constructor
	 * @param message
	 */
	public CartNotFoundException(String message)
	{
		super(message);
	}
}
