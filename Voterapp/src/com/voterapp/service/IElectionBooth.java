package com.voterapp.service;

import com.voterapp.exceptions.InvalidVoterException;
import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;

public interface IElectionBooth {
	boolean checkEligibility(int age, String locality, int voterId) throws InvalidVoterException,LocalityNotFoundException,NoVoterIDException;
}