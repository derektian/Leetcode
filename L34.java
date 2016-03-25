/* L34 Search for a range
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/		
/*
思路：二分法搜索最大最小范围。二分原本是精确搜索，现在变为范围搜索。
如果是搜索下界，那么nums[mid]只要大于等于目标值(原本是大于，现在多了==相当于多向下搜索)，low就变为mid。同理搜索上界。
*/
public class L34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] location = new int[2];
        int lowMin = 0;
        int highMin = nums.length - 1;
        while(lowMin + 1 < highMin) {
            int midMin = lowMin + ((highMin - lowMin) >> 1);
            if(nums[midMin] >= target) {
                highMin = midMin;
            } else{
                lowMin = midMin;
            }
        }
        if(nums[lowMin] == target) {
        	location[0] = lowMin;
        } else if(nums[highMin] == target) {
        	location[0] = highMin;
        } else {
        	location[0] = -1;
        }
        
        int lowMax = 0;
        int highMax = nums.length - 1;
        while(lowMax + 1 < highMax) {
            int midMax = lowMax + ((highMax - lowMax) >> 1);
            if(nums[midMax] <= target) {
                lowMax = midMax;
            } else{
                highMax = midMax;
            }
        }
        if(nums[highMax] == target) {
        	location[1] = highMax;
        } else if(nums[lowMax] == target) {
        	location[1] = lowMax;
        } else {
        	location[1] = -1;
        }
        
        return location;
    }
    
	public static void main(String[] args) {
		
		int[] nums = {5,7,7,8,8,8,10};
		int target = 10;
		
		int[] location;
		location = searchRange(nums, target);
		System.out.println(location[0] + " " + location[1]);
	
	}
}
