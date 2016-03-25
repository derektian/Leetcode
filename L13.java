/* L13 Roman to Integer
Given a roman numeral, convert it to an integer.
Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1,000
I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)
X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)
C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and 
nine hundred is CM (a hundred less than a thousand)
1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
1000~3000: {"M", "MM", "MMM"}
Input is guaranteed to be within the range from 1 to 3999.
*/
import java.util.*;
public class L13 {
	//思路：分析对应的字母，相加对应数字即可。对于出现的双字母情况，都是数字小的在数字大的前面，易判断。减去两次对应的数值即可
	public static int romanToInt(String s) {
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		hashmap.put('I', 1); hashmap.put('V', 5); hashmap.put('X', 10); hashmap.put('L', 50);
		hashmap.put('C', 100); hashmap.put('D', 500); hashmap.put('M', 1000);
		
		int sum = hashmap.get(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(hashmap.get(s.charAt(i)) > hashmap.get(s.charAt(i-1))) {
				//i-1时候加过一次，这里需要减去这次的数值
				sum += hashmap.get(s.charAt(i)) - 2 * hashmap.get(s.charAt(i-1));
			} else {
				sum += hashmap.get(s.charAt(i));
			}
		}
		
		return sum;
    }
	//由上面思路相反，把num中数字挨个减去即可；也可用%/方法，但是列出所有数字，
//	1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//	10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//	100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//	1000~3000: {"M", "MM", "MMM"}
//	再由这个二维数组求解。
	public static String intToRoman(int num) {
		String romanNumeral = "";
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000, 900, 500, 400, 100, 90,  50, 40,  10,  9,  5,  4,   1};
        int i = 0;
        while(num != 0) {
        	if(num >= number[i]) {
        		num -= number[i];
        		romanNumeral += symbol[i];
        	} else {
        		i++;
        	}
        }
		return romanNumeral;
    }
	
	
	public static void main(String[] args) {
//		String s = "MCMXCVI"; MCMDCDCXCVI  MMCMXCVI

		int num = 2996;
		System.out.println(intToRoman(num));
	}
}
