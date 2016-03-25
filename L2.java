/*L2 Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order 
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 0 -> 8
*/		
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
        if(l2 == null) return l1;
        
    	ListNode result = new ListNode(0);
        ListNode head = result;
        boolean flag = false;
        int val;
        
        while(l1 != null || l2 != null) {
        	//notice that the order of the judgement imfluence the time complexity
        	if(l1 != null && l2 != null) {
        		val = l1.val + l2.val;
        	} else if(l1 != null && l2 == null) {
        		val = l1.val;
        	} else {
        		val = l2.val;
        	}
        	
        	if(flag) {
        		++ val;
        		flag = false;
        	}
        	if(val >= 10) {
        		val = val - 10;
        		flag = true;
        	}
        	ListNode temp = new ListNode(val);
        	result.next = temp;
        	result = result.next;
        	
        	if(l1 != null) {
        		l1 = l1.next;
        	}
        	if(l2 != null) {
        		l2 = l2.next;
        	}
        }

        while(l1 == null && l2 == null && flag == true) {
    		ListNode temp = new ListNode(1);
			result.next = temp;
			result = result.next;
			flag = false;
    	}
    	
        return head.next;
    }
    public static void main(String[] args) {
//    	ListNode l1 = new ListNode(2);
//    	ListNode node2 = new ListNode(2);
//    	ListNode node3 = new ListNode(5);
//    	ListNode node4 = new ListNode(1);
//    	l1.next = node2;
//    	node2.next = node3;
//    	node3.next = node4;
//    	node4.next = null;
//    	
//    	ListNode l2 = new ListNode(3);
//    	ListNode node5 = new ListNode(4);
//    	ListNode node6 = new ListNode(8);
//    	l2.next = node5;
//    	node5.next = node6;
//    	node6.next = null;
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(9);
    	//ListNode l3 = new ListNode(9);
    	l1.next = null;
    	l2.next = null;
//    	l3.next = null;
    	
    	L2 test = new L2();
		ListNode res = test.addTwoNumbers(l1, l2);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
