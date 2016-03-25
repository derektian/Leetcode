/*L65 Valid Number
  Validate if a given string is numeric.
*/
/*
 * 思路：字符串处理，考虑周全
 * 1.null or empty string  2.整数判断   3.小数判断  4.幂指数e2判断  5.+/-号不算numeric 
 * 'e' '0e' 'e9' false 
 * '-.' '.e1'  false  
 * '-1.' '.1' '46.e3'true
 *  
 */
//主要是e和.的考虑，可以考虑以这两个为标准分割字符串。
//下面的解法使用了有限状态机。通过状态的转移来判断。
public class L65 {
	public boolean isNumber(String s) {
        if(s==null || s.length()==0) return false;  
        int sz = s.length();  
        int i=0;  
          
        while(i<sz && s.charAt(i)==' ') ++i;  
          
        boolean space = false;  
        boolean exp = false;  
        boolean dot = false;  
        boolean number = false;  
        boolean neg = false;  
          
        for(; i<sz; i++) {  
            char c = s.charAt(i);  
            if(c==' ') {  
                space = true;  
            } else if(space==true) {  
                return false;  
            } else if( (c=='e' || c=='E') && exp==false && number==true) {  
                exp = true;  
                number = false;  
                dot = true;  
                neg = false;  
            } else if( c=='.' && dot==false) {  
                dot = true;  
                neg = true;  
               // number = false;  
            } else if( c>='0' && c<='9') {  
                number = true;  
            } else if((c=='+' || c=='-') && neg==false && number==false ) {  
                neg = true;  
            } else {  
                return false;  
            }  
        }  
        return number;  
    }
    
    public static void main(String[] args) {
		L65 test = new L65();
		System.out.println(test.isNumber(" 46.e3 "));
	}
}
