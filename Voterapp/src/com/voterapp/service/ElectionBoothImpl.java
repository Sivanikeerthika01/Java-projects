package com.voterapp.service;

import com.voterapp.exceptions.InvalidVoterException;

import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.exceptions.UnderAgeException;


public class ElectionBoothImpl implements IElectionBooth {

	String[] localities = {"Belandur", "Silkboard", "ElectronicCity", "Agra"};
	
	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InvalidVoterException, LocalityNotFoundException, NoVoterIDException {
		 try {
			if(checkAge(age))
				if(checkLocality(locality))
					if(checkVoterId(voterId))
						return true;
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		} catch(LocalityNotFoundException e) {
			System.out.println("You are not from the following localities : ");
			int i = 1;
			for(String location : localities) {
				System.out.println(i + ". " +location);
				i++;
			}
		} catch(NoVoterIDException e) {
			System.out.println(e.getMessage());
		}
		throw new InvalidVoterException("I'm sorry, You're not eligible.");
	}
	
	
	public boolean checkAge(int age) throws UnderAgeException {
		if(age < 18) {
			throw new UnderAgeException("You're below 18.");
		}
		return true;
	}
	
	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		for(String location : localities) {
			if(location.equalsIgnoreCase(locality)) {
				return true;
			}
		}
		throw new LocalityNotFoundException();
	}
	
	public boolean checkVoterId(int voterId) throws NoVoterIDException {
		if(voterId >= 1000 && voterId <= 9999) {
			return true;
		}
		throw new NoVoterIDException("Your voter ID is Invalid.");
		
	}
	
	
	
	

}
