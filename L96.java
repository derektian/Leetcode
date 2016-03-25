/* L96 Unique Binary Search Trees
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
tags:tree, dp
*/
/*
思路：如果利用递归，会反复调用，时间复杂度不满足。因此考虑利用动态规划，一个一维数组。
维持一个数组，这个数组中存放的是中间计算结果（即 1~n-1 对应的BST数目）。比如求n节点的BST数目，当n作为根节点的时候，左子树可以有0到n-1个节点，对应的，右子树可以有n-1到0个节点
两边对应的情况分别相乘即可得到所有的情况。
*/

public class L96 {
	public int numTrees(int n) {
		if(n == 0) return 1;
		if(n == 1) return 1;
		
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= n; i++) {
        	int record = 0;
        	for(int j = 0; j < i; j++) {
        		record += nums[j] * nums[i-j-1];
        	}
        	nums[i] = record;
        }
        
		return nums[n];
    }
	
	public static void main(String[] args) {
		L96 test = new L96();
		System.out.println(test.numTrees(3));
	}
}
