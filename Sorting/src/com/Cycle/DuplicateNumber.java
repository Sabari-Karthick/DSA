package com.Cycle;

public class DuplicateNumber {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 3, 4, 2 };
		int ans = findDuplicate(arr);
		System.out.println(ans);
	}

	private static int findDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length) {
        	int correctIndex = arr[i]-1;
        	if(arr[i]!=arr[correctIndex]) {
        		swap(arr, i, correctIndex);
        	}else {
        		i++;
        	}
        }
		
        for(int j=0;j<arr.length;j++) {
        	if(arr[j]!=j+1 && arr[j]==arr[arr[j]-1]) {//if the element is not equal to index+1 check if the original index which id  value-1 has that value 
        		return arr[j];//if 3 is duplicate check index 2 has 3 to confirm it is the duplicate
        	}
        }
        
        
		return -1;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
