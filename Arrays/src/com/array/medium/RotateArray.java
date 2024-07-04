package com.array.medium;

import java.util.Arrays;

public class RotateArray {
public static void main(String[] args) {
	int arr[] = {1,2,3,4,5,6,7};
	rotateArray(arr, 3);
	System.out.println(Arrays.toString(arr));
}
public static void rotateArray(int arr[],int rotateCount) {
	int a[] = new int[arr.length];
	for(int i=0;i<arr.length;i++) {
		a[(i+rotateCount)%arr.length]=arr[i];
	}
	for (int j = 0; j < a.length; j++) {
		arr[j] = a[j];
	}
}
}
