package com.lumen.assignments;

public class Prime {

	public static void main(String[] args) {
		int number=13;
		int flag=0;
		for(int i=1;i<=number;i++) {
			if(number%i==0) {
				flag++;
		}
		

	}
	if(flag==2)
		System.out.println("Prime");
	else
		System.out.println("Not a Prime");
	}
}
