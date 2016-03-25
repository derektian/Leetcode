//import java.util.*;

/*L18 4Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.
*/

//思路:与3Sum近似，头尾两根指针移动，中间两根指针移动。
//判断重复直接用hashset来处理，hashset添加List，最后直接new list<list>即可
/*
public class L18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	//List<List<Integer>> result = new LinkedList<List<Integer>>();
    	HashSet resSet = new HashSet();
    	
    	if(nums == null || nums.length < 3) return new LinkedList<List<Integer>>(resSet);
    	
    	int len = nums.length;
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0; i < len-3; i++) {
    		for(int j = len-1; j > i+2; j--) {
    			int tmpVal = target - nums[i] - nums[j];
    			int low = i + 1;
        		int high = j - 1;
        		while(low < high) {
        			if(nums[low] + nums[high] == tmpVal) {
        				List<Integer> temp = new LinkedList<Integer>();
        				temp.add(nums[i]);
        				temp.add(nums[low]);
        				temp.add(nums[high]);
        				temp.add(nums[j]);
        				resSet.add(temp);
        				low ++;
        				high --;
        			} else if(nums[low] + nums[high] < tmpVal){
        				low ++;
        			} else if(nums[low] + nums[high] > tmpVal){
        				high --;
        			}	
        		}
    		}
    	}
    	
    	return new LinkedList<List<Integer>>(resSet);
    }
    
    public static void main(String[] args) {
    	//int[] nums = {1, 0, -1, 0, -2, 2};
    	int[] nums = {};
    	int target = 0;
    	L18 test = new L18();
    	System.out.println(test.fourSum(nums, target));
	}
}
*/