import java.util.*;
/*L16 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.
*/
public class L16 {
    public int threeSumClosest(int[] nums, int target) {
    	long result = Integer.MAX_VALUE;
    	
    	if(nums == null || nums.length < 3) return 0;
    	
    	int len = nums.length;
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0; i < len-2; i++){
    		int low = i + 1;
    		int high = len - 1;
    		while(low < high) {
    			int temp = nums[low] + nums[high] + nums[i];
    			if(temp == target) {
    				return target;
    			} else {
    				if(Math.abs(temp-target) < Math.abs(result-target)) {
    					result = temp;
    				}
    				if(temp < target) {
	    				low ++;
	    			} else if(temp > target){
	    				high --;
	    			}
    			}    		
    		}
    	}
    	
    	return (int)result;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-3, -2, -5, 3, -4};
    	int target = -1; 
		L16 test = new L16();
		System.out.println(test.threeSumClosest(nums, target));
	}
}
