package com.lumen.assignments;

public class Sumavg {

	public static void main(String[] args) {
		int[] array= {1,5,10,80};
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		int average=sum/array.length;
		System.out.println("Sum "+sum);
		System.out.println("Average "+average);

	}

}
