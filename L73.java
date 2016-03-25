/* L73 set matrix zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
tags:array
similar problems:L289 Game of life
*/
/*
思路：由于是在289之后马上就做，很容易就把289的思路代入，考虑状态的变化，然后忽略了这又不是只有0,1的游戏，随便标记就行。
	矩阵存储任意数字，所以用状态变化AC是比较侥幸。如果遇到正好和状态变化相同标记值相同的数据，就failed。
	正常思路是利用第一行第一列来存储哪行哪列有0。类似于加一行一列（空间复杂度是O（m+n）），但是本题要求只有O（1）。
	先标记第一行/列是否有0，再遍历，遇到0的话，那就把其所在行列的第一个值标为0即可。最后统一结算。
*/
public class L73 {
	
	public static void main(String[] args) {
		int[][] matrix = {{-1},{2},{3}};
		setZeroes(matrix);
	}
	
    private static void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
//    	if(matrix == null)
//    		return ;
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(matrix[i][j] == 0 || matrix[i][j] == Integer.MAX_VALUE) {
    				for(int k = 0; k < n; k++) {
    					if(matrix[i][k] == 0 || matrix[i][k] == Integer.MAX_VALUE) 
    						matrix[i][k] = Integer.MAX_VALUE;
    					//else if(matrix[i][k] == 1 || matrix[i][k] == 3)
    					else
    						matrix[i][k] = 9991999;
    					
    				}
    				
    				for(int k = 0; k < m; k++) {
    					if(matrix[k][j] == 0 || matrix[k][j] == 9991998) 
    						matrix[k][j] = 9991998;
    					//else if(matrix[i][k] == 1 || matrix[i][k] == 3)
    					else
    						matrix[k][j] = 9991999;
    					
    				}
    			} 	
    		}
    	}
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(matrix[i][j] == 9991998 || matrix[i][j] == 9991999)
    				matrix[i][j] = 0;
    			//System.out.println(matrix[i][j]);
    		}
    	}
    	
    }
}
