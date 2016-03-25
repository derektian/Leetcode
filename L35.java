/*L35 search insert position
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class L35 {
	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int index = -1;
		
		while((low <= high) && (index == -1)) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				 index = mid;
			else if (nums[mid] > target)
				high = mid - 1;
			else 
				low  = mid + 1;
		}
		if(index != -1) {
			return index;
		} else {
			return low;
		}
		
/*		if(index != -1) {
			return index;
		} else {
			for(int i = 0; i < nums.length; i++) {
				if(target < nums[i]) {
					index = i;
					break;
				}
			}
			return index;
		}
*/    }
	
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 2;
		System.out.println(searchInsert(nums, target));
	}
}
