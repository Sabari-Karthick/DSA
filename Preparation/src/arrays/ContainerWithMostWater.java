package arrays;

public class ContainerWithMostWater {
public static void main(String[] args) {
	int []height = {1,8,6,2,5,4,8,3,7};
	System.out.println(maxArea(height));
}
public static int maxArea(int[] height) {
	int n=height.length;
  int max=0;
  int i=0;
  int j= n-1;
  while(i<j) {
	  max = Math.max(max, Math.min(height[i],height[j]) * (j-i));
	  if (height[i] < height[j])
          i++;
           
      else
          j--;
  }
    
    
    
    return max;
}
}
