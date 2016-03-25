/*L69 sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x.
*/
/*
 * 思路：采用2的倍数确定大致范围，在确定的范围内找到具体数值，但是这个最坏情况下遍历会达到O(n/a)的情况,虽然AC但并不简洁
 * 改进：明显就是二分查找法在0-x上的使用
 * 
 */
public class L69 {
    
/*  //思路1
	public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        
    	boolean isReturn = false;
    	long count = 1;
        while(true) {
        	if(count * count == x) {
        		isReturn = true;
        		return (int)count;
        	} else if(count * count < x) {
        		count <<= 1;
        	} else{
        		break;
        	}
        }
        
        long result = (count >> 1) + 1;
        if(!isReturn) {
        	while(true) {
            	if(result * result == x) {
            		return (int)result;
            	} else if(result * result < x) {
            		result ++;
            	} else{
            		break;
            	}
            }
        }
        return (int)(result-1); 
    }
*/  
	public int mySqrt(int x) {
		if(x == 0 || x == 1) return x;
		
		int low = 1;
		int high = x;
		int middle = 0;
		
		while(low <= high) {
			middle = low + ((high - low) >> 1);
			//middle * middle == x 的形式会溢出
			if(middle == x / middle) {
				return middle;
			} else if(middle < x / middle) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		
		return high;
	}
	
    public static void main(String[] args) {
		L69 test = new L69();
		System.out.println(test.mySqrt(Integer.MAX_VALUE));
		
	}
}
