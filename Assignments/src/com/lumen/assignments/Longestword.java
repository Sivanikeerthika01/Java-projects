package com.lumen.assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Longestword {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String sentence=scanner.nextLine();
		String [] sentenceList=sentence.split(" ");
		int [] countList=new int[sentenceList.length];
		for(int i=0;i<sentenceList.length;i++) {
			countList[i]=sentenceList[i].length();
			
		}
		int max=countList[0];
		for(int num:countList) {
			if(num>max) {
				max=num;
			}
		}
		int index=Arrays.binarySearch(countList,max);
		String longestWord=sentenceList[index];
		System.out.println("Longest is "+longestWord+" counts "+max+" times");
				
				scanner.close();
	}

	
}
