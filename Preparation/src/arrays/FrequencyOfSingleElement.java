package arrays;

import java.util.Arrays;

public class FrequencyOfSingleElement {
	public static void main(String[] args) {
		int arr[]= {10,1,4,7,10,1,1,1,2,6,2,7,1};
		int n=1;
		System.out.println(countFrequency(arr,n));

	}
	public static int countFrequency(int arr[],int n) {
		int count =(int) Arrays.stream(arr).filter(i->i==n).count();
		return count;
	}
}
