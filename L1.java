/*Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.
*/
import java.util.*;
public class L1 {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	int[] temp = new int[nums.length];
    	
    	for (int i = 0; i < temp.length; i++) {
    		temp[i] = nums[i];
		} 
    	
    	Arrays.sort(temp);
    	
    	int low = 0;
    	int high = nums.length-1;
    	
    	while(low < high) {
    		if(temp[low] + temp[high] == target) 
    			break;
    		else if(temp[low] + temp[high] < target) {
    			low ++;
    		} else if(temp[low] + temp[high] > target) {
    			high --;
    		}
    	}
    	
    	int index1 = 0;
    	int index2 = 0;
    	boolean flag = false;
    	for(int i = 0; i < nums.length; i++) {
    		if(temp[low] == nums[i] && !flag) { 
    			index1 = i + 1;
    			flag = true;
    		}
    		if(temp[high] == nums[i]) 
    			index2 = i + 1;
    	}
    	
    	result[0] = index1 < index2 ? index1 : index2;
    	result[1] = index1 > index2 ? index1 : index2;
    	
    	return result;
    }
    
    public static void main(String[] args) {
	/*	L1 test = new L1();
		int[] nums = {0,4,3,0};
		int target = 0;
		
		int[] res = test.twoSum(nums, target);
		for (int i : res) {
			System.out.println(i);
		}*/
    	
    	int a  = 3;
    	int b = a;
    	a = 4;
    	System.out.println(b);
	}
}
