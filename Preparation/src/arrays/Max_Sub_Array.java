package arrays;

import java.util.ArrayList;




public class Max_Sub_Array {
public static void main(String[] args) {
	int []arr = {1, 2, 5, -7, 2, 3};
	int  n=arr.length;
	ArrayList<Integer > ans =  findSubArray(arr,n);
	for(int i: ans ) {
		System.out.println(i);
	}
}
@SuppressWarnings("unused")
public static ArrayList<Integer> findSubArray(int[] a,int n){
//	int max=0;
//	 ArrayList<Integer> list = new ArrayList<Integer>();
//	if(a[n-1]>0) {
//		max=a[n-1];
//		list.add(a[n-1]);
//
//	
//	}
//	for(int i=0;i<n-1;i++)
//			{
//		int  sum=Arrays.stream(a).dropWhile(j->j<0).sum();
//		System.out.println(sum);
//		System.out.println(max);
//		 if(sum>max) {
//			 max=sum;
//             list.clear();
//         	System.out.println(" #####");
//					 Arrays.stream(a).filter(j->j<a[0]).forEach(j->list.add(j));
//					 for (Integer integer : list) {
//							System.out.println(integer);
//					}
//		 }
//		
//			}
//	
//	
//	return  list;


	        int right = 0;

	        int start = 0;

	        int sum =0;

	        int maxSum = 0;

	        ArrayList<Integer> list = new ArrayList<>();

	        ArrayList<Integer> ans = null; 

	        while(right < n){

	            if(a[right] >= 0){

	                sum = sum + a[right];

	                list.add(a[right]);

	            }else{

	                if(sum > maxSum && !list.isEmpty()){

	                    ans = new ArrayList<>(list);

	                    maxSum = sum;

	                }

	                list.clear();

	                sum = 0;

	            }

	            right++;

	        }

	        if(sum > maxSum){

	            ans = new ArrayList<>(list);

	        }

	        if(ans == null){

	            ans = new ArrayList<Integer>();

	            ans.add(-1);

	        }

	        return ans;

	    }


}
