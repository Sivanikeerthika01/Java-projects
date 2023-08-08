package com.userapp.service;
import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidationServiceImpl implements IValidationService {
	@Override
	public boolean validateUsername(String Username)throws NameExistsException{
		return IValidationService.super.validateUsername(Username);
	}
	@Override
	public boolean validatePassword(String Password)throws TooLongException,TooShortException{
		return IValidationService.super.validatePassword(Password);
	}
	
	

}
