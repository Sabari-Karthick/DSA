package com.Linear;


public class SearchIn2D {
public static void main(String[] args) {
	int [][]arr = {
			{3,6,7},
			{34,76,21,9,19},
			{1,2,4}
	};

	System.out.println(find(arr, 19));
	
}
static String find(int arr[][],int target) {
	for (int rows = 0; rows < arr.length; rows++) {
		for (int col = 0; col < arr[rows].length; col++) {
			if(arr[rows][col]==target)
				return rows+":"+col;
		}
	}
	return -1+" ";
}
}
