package com.cg.oms.exception;

public class ErrorMessage
{
	private int errorCode;

	private String errorInformation;

	public int getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(int errorCode)
	{
		this.errorCode = errorCode;
	}

	public String getErrorInformation()
	{
		return errorInformation;
	}

	public void setErrorInformation(String errorInformation)
	{
		this.errorInformation = errorInformation;
	}

}
