/* L27 Remove elements
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

tags: array, two pointers
similar problems: L289 move zeroes, Remove linked list elements
*/
/*
思路：删除相同元素，但是必须in place来做。参考move zero 直接都移到队尾，前后两根指针就好。
易出错地方：返回的是length而不是tail，tail = length - 1
        边界条件，nums长度为0 和1的时候都要考虑下。
*/

public class L27 {
	public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
        	return 0;
        } else if(nums.length == 1) {
        	if(nums[0] == val) {
        		return 0;
        	} else {
        		return 1;
        	}
        } else {
        	int head = 0;
        	int tail = nums.length - 1;
        	
        	while(head <= tail) {
        		if(nums[head] != val) {
        			head ++;
        		} else {
        			for(int i = head; i < tail; i++) 
        				nums[i] = nums[i + 1];
        			tail --;
        		}
        	}
        	tail ++;
        	return tail;
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {3,3};
		int val = 3;
		int length = removeElement(nums, val);
		System.out.println(length);
	}
}
