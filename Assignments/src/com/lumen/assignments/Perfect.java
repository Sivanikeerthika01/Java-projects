package com.lumen.assignments;

import java.util.Scanner;

public class Perfect {

	public static void main(String[] args) {
		int number,sum=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number");
		number=scanner.nextInt();
		for(int i=1;i<number;i++) {
			if(number%i==0) {
				sum=sum+i;
			}
		}
		if(sum==number) {
			System.out.println(number+" is Prime");
		}
		else {
			System.out.println(number+"is Not prime");
		}

	}

}
