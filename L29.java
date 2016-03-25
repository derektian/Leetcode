/*L29. Divide Two Integers
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
 */
//思路：除法的本质是减法。时间复杂度O(n),但是肯定TLE

/*
 1. 被除数/除数=商 （忽略余数）=> 被除数=除数*商。

 2. 商（任意整数）可以表示为：a_0*2^0+a_1*2^1+...a_i*2^i+...+a_n*2^n.

 3. 在Java中左移操作<<相当于对一个数乘以2，右移操作相当于除以2.

 4.我们让除数左移直到大于被除数前的的一个数，例如计算28/3，我们进行三次左移操作，使3*2*2*2=3*8=24<28(注意四次左移操作得到3*2^4=48>28).记录下2*2*2=2^3=8.
 (也就是说，把被除数分解成一个个能被3整除的数，这个被3整除后的数应该是2的幂，可用于结果相加。)
 5.我们让28减去24得到4，然后像第四步一样计算4/3,则3*2^0=3<4.记录下2^0=1.

 6.由于4-3=1小于除数3，停止计算，并将每轮得到的值相加，在本例中8+1=9，记得到商（即28/3=9）。

 至此，程序的主题思想已经介绍完了，接下来要注意数据左移和求整数绝对值的边界问题。

 7. 将输入的Int(32位)型数字转换为long(64位)型。

 8. 考虑MIN_VALUE/-1的特殊情况。
 */
public class L29 {
	public int divide(int dividend, int divisor) {
		boolean isNeg = ((dividend ^ divisor) >>> 31 == 1);
		
		long did = Math.abs((long)dividend);
		long dis = Math.abs((long)divisor);
		
		long quotient = 0;
		while(did >= dis) {
			long k = dis;
			int i = 0;
			while((k << 1) < did) {
				k <<= 1;
				++ i;
			}
			did -= k;
			quotient += 1 << i;
		}
		//包含了MIN_VALUE / -1的情况和两正数相除越界的情况
		if(quotient > Integer.MAX_VALUE && !isNeg) 
			return Integer.MAX_VALUE;
		
		return (int) (isNeg ? -quotient : quotient);	
	}

	public static void main(String[] args) {
		// int dividend = 2147483647;
		int dividend = -2147483648;
		int divisor = 1;
		L29 test = new L29();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(test.divide(dividend, divisor));
	}
}
