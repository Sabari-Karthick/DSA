package arrays;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
public static void main(String[] args) {
	int arr[] = {1,2,3,4,5};
	Integer []a = Arrays.stream(arr).boxed().toArray(Integer[]::new);
	//int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
		reverse(arr);
	
	System.out.println(Arrays.toString(arr));
	rotate(a,2);
	System.out.println(Arrays.toString(a));

}

private static void reverse(int[] arr) {
//Collections.reverse(Arrays.asList(arr));
	int start = 0;
	int end =arr.length-1;
	while(start<end) {
		swap(arr,start,end);
		start++;
		end--;
	}
}
private static void swap(int []arr,int index1 , int index2) {
	int temp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = temp;
	
}
private static void rotate(Integer[] arr,int x) {
Collections.rotate(Arrays.asList(arr),x);
}
}
