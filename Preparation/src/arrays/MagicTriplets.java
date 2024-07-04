package arrays;


public class MagicTriplets {
public static void main(String[] args) {
	int []arr = {1, 2, 3, 4};
	System.out.println("the triplet is:"+countTriplets(arr));

}
public static int countTriplets(int[] nums){
    int ans=0;
	    for(int j=0;j<nums.length;j++) {
	        int small =0;
	        for(int i=0;i<j;i++) {
	            if(nums[i]<nums[j]) small++;
	        }
	   
	        
	        int large =0;
	        for(int k=j+1;k<nums.length;k++) {
	            if(nums[j]<nums[k]) large++;
	        }
	        ans+=(small*large);
	    }
	    return ans;
	
	

   }
}
