package com.lumen.assignments;

public class Palindrome {

	public static void main(String[] args) {
		int remainder,sum=0,count;    
		  int number=454;//It is the number variable to be checked for palindrome  
		  
		  count=number;    
		  while(number>0){    
		   remainder=number%10;  //getting remainder  
		   sum=(sum*10)+remainder;    
		   number=number/10;    
		  }    
		  if(count==sum)    
		   System.out.println("palindrome");    
		  else    
		   System.out.println("Not palindrome");    
		}  

	}


