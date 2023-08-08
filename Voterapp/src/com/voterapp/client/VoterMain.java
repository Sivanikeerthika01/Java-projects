package com.voterapp.client;

import java.util.Scanner;

import com.voterapp.exceptions.InvalidVoterException;
import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;


public class VoterMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter age");
		int age=scanner.nextInt();
		System.out.println("Enter locality");
		String locality=scanner.nextLine();
		System.out.println("Enter voterId");
		int voterid=scanner.nextInt();
		IElectionBooth electionbooth=new ElectionBoothImpl();
		try {
			if(electionbooth.checkEligibility(age, locality, voterid)) {
				System.out.println("valid vote");
			}
		}catch(InvalidVoterException | LocalityNotFoundException | NoVoterIDException e) {
			System.out.println(e.getMessage());
		}
		
		
		scanner.close();

	}

}
