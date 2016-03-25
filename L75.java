/*L75 Sort Colors
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with an one-pass algorithm using only constant space?
*/

public class L75 {
	
/*	//two-pass
    public void sortColors(int[] nums) {
    	if(nums.length < 2) return ;
    	
        int[] count = new int[3];
        
    	for (int num : nums) {
			count[num] ++;
		}
    	
    	Arrays.fill(nums, 0, count[0], 0);
    	Arrays.fill(nums, count[0], count[0] + count[1], 1);
    	Arrays.fill(nums, count[0] + count[1], count[0] + count[1] + count[2], 2);
    }
  
	//one-pass 1. sort the list similar with two pointers
	public void sortColors(int[] nums) {
		if(nums.length < 2) return;
		int low = 0;
		int high = nums.length - 1;
		int i = 0;
		while(i <= high) {
			if(nums[i] == 0) {
				swap(nums, low, i);
                low ++;
                i ++;
			} else if(nums[i] == 1) {
				i++;
			} else {
				swap(nums, i, high);
				high --;
			}
		}
	}
*/	
	//one-pass 2.
	public void sortColors(int[] nums) {
		if(nums.length < 2) return;
		int i = -1;
		int j = -1;
		int k = -1;
		
		for(int m = 0; m < nums.length; m ++) {
			if(nums[m] == 0) {
				nums[++k] = 2;
				nums[++j] = 1;
				nums[++i] = 0;
			} else if(nums[m] == 1) {
				nums[++k] = 2;
				nums[++j] = 1;
			} else {
				nums[++k] = 2;
			}
		}
	}
		
	
	public void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}
	
    public static void main(String[] args) {
//		int[] nums = {1,2,0,2,1,2,0,1,2,0};
    	int[] nums = {2,1};
    	L75 test = new L75();
		test.sortColors(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}
