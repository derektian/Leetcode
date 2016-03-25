/* L24 Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
//思路：链表的基本操作，注意截止条件和循环结束后的链表指向情况。
public class L24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        head = curr;
        ListNode next = curr.next;
        
        while(next != null && next.next != null) {
        	curr.next = prev;
        	prev.next = next.next;
        	
        	prev = next;
        	curr = next.next;
        	next = curr.next;
        }
        curr.next = prev;
        prev.next = next;
    	
    	return head;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = null;
		
		L24 test = new L24();
		ListNode newHead = test.swapPairs(l1);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
		
	}
}
