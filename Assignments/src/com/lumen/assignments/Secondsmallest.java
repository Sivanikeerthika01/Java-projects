package com.lumen.assignments;

 

public class Secondsmallest {

 

    public static void main(String[] args) {

          int temp;

          int array[] = {10,3,5,67,89};

          for(int i = 0; i<array.length; i++ ){

             for(int j = i+1; j<array.length; j++){

                if(array[i]>array[j]){

                   temp = array[i];

                   array[i] = array[j];

                   array[j] = temp;

                }

             }

          }

          System.out.println("2nd Smallest element of the array is "+array[1]);

    }

 

}