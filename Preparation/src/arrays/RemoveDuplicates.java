package arrays;



public class RemoveDuplicates {
	public static void main(String[] args) {
		int []arr = {1,1,2};
		int k=removeDuplicates(arr);
		System.out.println(k);
	}
public  static int removeDuplicates(int[] nums) {
	
	  int n = nums.length;
	if(n==0 || n==1) {
		return n;
	}
	int j=0;
	for(int  i=0;i < n-1;i++) 
	{
		if(nums[i]!=nums[i+1]) 
		{
			nums[j++]=nums[i];//store if the next element is not same 
		}
		
	}
	nums[j++]=nums[n-1];//store the last element
	return j;
          
    }

}
