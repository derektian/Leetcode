/* 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
*/
/*
 * 思路：暴力解法 时间O(n^3)
 * 如何优化：考虑从问题3Sum退化为2Sum问题，时间复杂度降低为O(n^2)
 * 排序的时间复杂度O(nlogn),不妨先排序。那么就可以考虑使用two pointer的思路来判断2sum的问题。
 * 
 * 这里有个坑：List的contains方法，肯定会查找，二分查找的时间复杂度也是O(logn),所以会造成TLE。
 * 既然已经排序，那么如果外围连续循环的核心值不变的话，就可以continue这次循环，避免contains方法。
 */

import java.util.*;

public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	
    	if(nums == null || nums.length < 3) return result;
    	
    	int len = nums.length;
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0; i < len-2; i++){
    		if(i > 0 && nums[i] == nums[i-1]) continue;
    		int low = i + 1;
    		int high = len - 1;
    		while(low < high) {
    			if(nums[low] + nums[high] == -nums[i]) {
    				List<Integer> temp = new LinkedList<Integer>();
    				temp.add(nums[i]);
    				temp.add(nums[low]);
    				temp.add(nums[high]);
    				result.add(temp);
//    				if(!result.contains(temp)) 
//    					result.add(temp);
    				while(low < high && nums[low] == nums[low + 1]) low ++;
    				while(low < high && nums[high] == nums[high - 1]) high --;
    				low ++;
    				high --;
    			} else if(nums[low] + nums[high] < -nums[i]){
    				low ++;
    			} else if(nums[low] + nums[high] > -nums[i]){
    				high --;
    			}
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		L15 test = new L15();
//		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] nums = {0,0,0,0};
		List<List<Integer>> res = test.threeSum(nums);
		System.out.println(res);
	}
}
