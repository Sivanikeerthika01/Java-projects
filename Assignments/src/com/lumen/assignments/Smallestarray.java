package com.lumen.assignments;

public class Smallestarray {

	public static void main(String[] args) {
		int [] array= {100,40,500,50,15};
		int min=array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i]<min) {
				min=array[i];
		}
		}
		System.out.println(min);

	}

}
