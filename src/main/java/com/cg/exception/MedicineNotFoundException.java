package com.cg.exception;

public class MedicineNotFoundException extends Exception
{

	private static final long serialVersionUID = 1L;

	public MedicineNotFoundException(String message)
	{
		super(message);
	}

}
