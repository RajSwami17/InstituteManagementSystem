package com.institute.exception;

import lombok.Data;


@Data
public class InstituteServiceCustomException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public InstituteServiceCustomException(String message, String errorCode) 
	{
		super(message);
		this.errorCode = errorCode;
	}
}
