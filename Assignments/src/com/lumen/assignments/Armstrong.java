package com.lumen.assignments;

public class Armstrong {

	public static void main(String[] args) {
		 int number=371;
		int number1,remainder,result=0;
		number1=number;
		while(number1!=0) {
			remainder=number1%10;
			result+=Math.pow(remainder, 3);
			number1/=10;
		}
		if(result==number)
			System.out.println(number + "is Armstrong");
		else
			System.out.println(number + "is not Armstrong");
		

	}

}
