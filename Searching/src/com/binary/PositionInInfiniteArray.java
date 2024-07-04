package com.binary;

import java.util.Arrays;

public class PositionInInfiniteArray {//bottom up approach of a binary search
	public static void main(String[] args) {
		int arr[] = {-4,3,5,603,647,25134,23,0,34,12,9836,357401,32,67,54};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(ans(arr,5));
	}
	static int ans(int arr[],int target) {
		//keep doubling until the target becomes less than end that is get within the range
		int start = 0;
		int end = 1;
		while(target > arr[end]) {
			int newStart = end+1;//we need old start
			end = end + (end-start+1)*2;
			start=newStart;
		}
		return binarySearch(arr, target, start, end);
	}
	static int binarySearch(int arr[], int target,int start,int end) {//search by chunks by doubling the chunks
		 
			while(start<=end) {
				int mid = start + (end - start)/2;
				if(arr[mid]<target) {
					start = mid+1;
				}
				else if (arr[mid]>target) {
					end = mid-1;
				}
				else {
					return mid;
				}
			}
			
			
			return -1;
		}
}
