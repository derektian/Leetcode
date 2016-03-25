/*L9 Palindrome Number
Determine whether an integer is a palindrome. Do this without extra space.
some hints:
Could negative integers be palindromes? (ie, -1)
If you are thinking of converting the integer to string, note the restriction of using extra space.
You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/
//思路：不能用额外空间，所以只能获取前后数值进行比较，也即获得数的长度，每次提取数字比较。

public class L9 {
    public boolean isPalindrome(int x) {
    	//小于0不是回文数
    	if(x < 0) return false;
        int divide = 1;
        int temp = x;
        
        while(temp/10 != 0) {
        	divide = divide * 10;
        	temp = temp / 10;
        }
        while(x != 0) {
        	if(x / divide != x % 10) {
        		return false;
        	}
        	x = (x % divide) / 10;
        	divide = divide / 100;
        }
        return true;
        
    }
    
    public static void main(String[] args) {
		int x = 12321;
		L9 test = new L9();
		
		System.out.println(test.isPalindrome(x));
	}
}
