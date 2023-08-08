package com.lumen.assignments;

public class Sortascend {

	public static void main(String[] args) {
		int[] array=new  int[] {10,34,32,56,31,25};
		int count=0;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					count=array[i];
					array[i]=array[j];
					array[j]=count;
				}
			}
		}
		for(int i=0;i<array.length;i++) {
	System.out.println(array[i]);

	}
	}
}
