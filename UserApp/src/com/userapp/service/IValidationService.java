package com.userapp.service;
import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public interface IValidationService {
	default boolean validateUsername(String Username)throws NameExistsException{
	String[] usernames= {"Sivani","Keerthi","Sri"};
	for(String UserName:usernames) {
		if(UserName.equals(usernames)) {
			throw new NameExistsException("Name is there");
		}
	}
	return true;
	}
		
		
		
		
	
	default boolean validatePassword(String Password)throws TooShortException,TooLongException{
		if(Password.length()<6)
			throw new TooShortException("Less than 6");
	
	if(Password.length()>16)
		throw new TooLongException("Greater than 15");


	return true;
}
}
