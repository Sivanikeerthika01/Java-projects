package com.lumen.assignments;
public class CountDuplicates {
    public static void main(String[] args) {
        int i = 0, j, count = 0;

        int[] array = {10,20,50,10,25,50,10};
        while(i < array.length) {

            j = i + 1;

            while(j < array.length)

            { 
            	if(array[i] == array[j]) {

                    count++;

                    break;

                }

                j++;

            }

            i++;

        }

        System.out.println("Total Number of Duplicates is " + count);

    }

 

}
