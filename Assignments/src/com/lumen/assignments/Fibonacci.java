package com.lumen.assignments;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		int b=2;
		int count=10,c;
		System.out.println(a+"\n"+b);
		for(int i=0;i<count;i++) {
		c=a+b;
		System.out.println(c);
		a=b;
		b=c;

	}
	}
}
