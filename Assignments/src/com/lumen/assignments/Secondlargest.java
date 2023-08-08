package com.lumen.assignments;

 

public class Secondlargest {

 

    public static void main(String[] args) {

 

          int temp;

          int array[] = {10, 30, 20, 40, 50};

          for(int i = 0; i<array.length; i++ ){

             for(int j = i+1; j<array.length; j++){

 

                if(array[i]>array[j]){

                   temp = array[i];

                   array[i] = array[j];

                   array[j] = temp;

                }

             }

          }

          System.out.println("second largest number is "+array[array.length-2]);

    }
}

 