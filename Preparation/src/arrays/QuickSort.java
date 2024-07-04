package arrays;



import java.util.Random;

public class QuickSort {//1.Choose pivot 2.Partition ->left is smaller than pivot and right is larger 3.Repeat recursively

	public static void main(String[] args) {
		Random r = new Random();
		int []inputArray = new int[100000];
		for(int i=0;i<inputArray.length;i++)
		{
			inputArray[i]=r.nextInt(10000);
		}
		System.out.println("Array before sorted:");
		printArray(inputArray);
		quickSort(inputArray,0,inputArray.length-1);
		System.out.println("Array before sorted:");
		printArray(inputArray);
		
	

	}
	private static void printArray(int inputArray[])
	{
	for(int i: inputArray) {
			System.out.println(i);
		}
	}
    private  static void quickSort(int inputArray[], int lowIndex , int highIndex)//index to do it recursively after partitioning
    {
    	if(lowIndex>=highIndex) {//if only one element in the array
    		return;
    	}
    	int pivot = inputArray[highIndex];
    	int left = lowIndex;
    	int  right = highIndex;
    	while (left<right) {//partitioning
    	while (inputArray[left]<= pivot && left < right) {
    		left++;
    		
    	}
    	while (inputArray[right]>= pivot && left < right) {
    		right--;
    		
    	}
    	swap(inputArray, left, right);
    	}
    	swap(inputArray, left, highIndex);//highIndex is the  pivot
    	quickSort(inputArray, lowIndex, left-1);
    	quickSort(inputArray, left+1,highIndex);
    }
	private static void swap(int[] inputArray , int i1,int i2) {
		int temp = inputArray[i1];
		inputArray[i1]=inputArray[i2];
		inputArray[i2]=temp;
	}

	}


