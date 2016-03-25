/* Reverse Integer
   Reverse digits of an integer.
*/
//思路：常见%/，终止条件即为x!=0.需要注意的是反转会越界，一种处理方式为用更大的格式来存储，超过即可以返回0。
public class L7 {
    public int reverse(int x) {
    	int signed = (x < 0) ? 1 : 0;
    	x = signed == 1 ? -x : x;
    	
    	long result = 0;
    	int digit;
    	
    	while(x != 0) {
    		digit = x % 10;
    		result = result * 10 + digit;
    		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) 
    			return 0;
    		x /= 10;
    	}
    	
    	return (signed == 0) ? (int)result : -(int)result;
    }
    
    public static void main(String[] args) {
		L7 test = new L7();
		System.out.println(test.reverse(1534236469));
	}
}
