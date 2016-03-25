/*String to Integer (atoi)
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below 
	  and ask yourself what are the possible input cases.
*/	  
/* 
 * 思路：题不难，关键是要考虑周全。
 * 1.可选正负号   2.是否是数字    3.char string integer之间的相互转换    4.最大最小值    5.null or empty string
 * 优化：Integer.parseInt等相互转换太费时间，其实只要char-‘0‘即可换数字
 */
public class L8 {
	public int myAtoi(String str) {
		str = str.trim();
		System.out.println(str);
		if(str.equals("")) return 0;
		long result = 0;
		char[] strChar = str.toCharArray();
		
		if(strChar[0] == '-') {
			int i = 1;
			while(i < str.length() && strChar[i] >= '0' & strChar[i] <= '9') {
				//result = result * 10 + Integer.parseInt(String.valueOf(strChar[i]));
				result = result * 10 + strChar[i] - '0';
				if(-result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				i++;
			}
			return -1 * (int)result;
		} else if(strChar[0] == '+') {
			int i = 1;
			while(i < strChar.length && strChar[i] >= '0' & strChar[i] <= '9') {
				//result = result * 10 + Integer.parseInt(String.valueOf(strChar[i]));
				result = result * 10 + strChar[i] - '0';
				if(result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				i++;
			}
			return (int)result;
		} else if(strChar[0] >= '0' & strChar[0] <= '9') {
			int i = 0;
			while(i < strChar.length && strChar[i] >= '0' & strChar[i] <= '9') {
				//result = result * 10 + Integer.parseInt(String.valueOf(strChar[i]));
				result = result * 10 + strChar[i] - '0';
				if(result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				i++;
			}
			return (int)result;
		} else {
			return (int)result;
		}
    }
	
	public static void main(String[] args) {
		L8 test = new L8();
		System.out.println(test.myAtoi("010"));
	}
}
