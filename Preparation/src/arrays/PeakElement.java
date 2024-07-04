package arrays;

public class PeakElement {
	public static void main(String[] args) {
		int []arr = {1,4,5,2,9,3};
		System.out.println("The peak element is in the index:"+peakElement(arr, arr.length));
		
	}
	public static int peakElement(int[] arr,int n)
    {
       
       int peakIndex=0;//have a peak variable
       for(int i =1 ;i<n;i++){//traverse from the second element by assuming that the first element is the peak
           if(arr[i]>arr[i-1]){//perform the comparison
               peakIndex=i;//and if true change the value of peak index
           }
       }
       
       return peakIndex;//then return
       
       
       
    }
}
