package arrays;

import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		Random r = new Random();
		int []inputArray = new int[100000];
		for(int i=0;i<inputArray.length;i++)
		{
			inputArray[i]=r.nextInt(10000);
		}
		System.out.println("Array before sorted:");
		printArray(inputArray);
		insertionSort(inputArray);
		System.out.println("Array before sorted:");
		printArray(inputArray);
		
	

	}
	private static void printArray(int inputArray[])
	{
	for(int i: inputArray) {
			System.out.println(i);
		}
	}
   
	private static void insertionSort(int inputArray[])
	{
       for(int i=1;i<inputArray.length ;i++) {
    	   int currentElement = inputArray[i];
    	   int j= i-1;
    	   while(j>=0 && currentElement < inputArray[j]) 
    	   {
    		   inputArray[j+1]=inputArray[j];
    		   j--;
    	   }
    	   inputArray[j+1]=currentElement;
       }
	
	}
}
