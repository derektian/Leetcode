/*L50. Pow(x, n)
Implement pow(x, n).
*/
//思路1：正常pow思路，O(n)复杂度，TLE
//改进：利用divide two integers的思路，3^12 9^6 81^3 6561*81 改进为O(logn)
//继续改进：pow(x,n) = pow(x,n/2) * pow(x,n-(n/2))，那么递归就可以用起来。

/*
 * bug record: n 是负数...
 * 当n是min_value时候，abs之后仍旧是-2147483648
 */
public class L50 {
	/*//改进1
    public double myPow(double x, int n) {
    	if(equals(x, 0)) return 0.0;
    	if(n == 0) return 1.0;
    	
    	boolean isNeg = (n < 0) ? true : false;
    	long count = Math.abs((long)n);
    	
    	double remain = 1.0;
    	while(count > 1) {
    		if((count & 1) == 1) {
    			remain *= x;
    			-- count;
    		}
    		count >>= 1;
    		x *= x;
    	}
    	x = x * remain;
    	
    	return (!isNeg) ? x : (1.0 / x);
    }
    */
    public double myPow(double x, int n) {
    	if(equals(x, 0)) return 0.0;
    	if(n == 0) return 1.0;
    	
    	if(n < 0) return 1.0 / myPow(x, -n);
    	
    	double half = myPow(x, n>>1);
    	if((n & 1) == 0) {
    		return half * half;
    	} else {
    		return half * half * x;
    	}
    }
    
    public boolean equals(double a, int b) {
    	if(a - b < 0.00001 && a - b > -0.00001)
    		return true;
    	return false;
    }
    
    public static void main(String[] args) {
		double x = 2.00000;
		int n = -2147483648;
		
		L50 test = new L50();
		System.out.println(test.myPow(x, n));
	}
    
}
 