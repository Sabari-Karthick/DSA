package arrays;

import java.util.Arrays;

public class MaxAndMinAndSecondMax {
	public static void secondMax(int []arr) {
		int size=arr.length;
		if(arr.length<2) {
			return; 
		}
		else {
			Arrays.sort(arr);
			for(int  i = size-2;i>=0;i--) {
				if(arr[i]!=arr[size-1]) {
					System.out.println("the second max is:"+arr[i]);
					return;
				}
				
			}
			System.out.println("there is no second largest");
			
		}
	}
public static void main(String[] args) {
	int []num = new int[] {3,2,3,1,2,4,5,5,6};
	int max = Arrays.stream(num).max().getAsInt();
	System.out.println("the max element is:"+max);
	System.out.println("the min element is:"+Arrays.stream(num).min().getAsInt());
try{
	System.out.println(Arrays.stream(num).filter(n->n!=max).sorted().max().getAsInt());
}
catch (Exception e) {
	System.out.println(-1);
}
secondMax(num);
}
}
