/*L92 Reverse Linked List
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
/*
思路1. 可以转化为找到m节点，然后找到n节点，reverse函数，注意保存m的前一个节点和n的后一个节点，将链表串在一起。思路比较清晰直接，但是m到n的节点要遍历两遍。
思路2. 找到m节点之后，保存m之前的一个节点pre，m后面的点插入到pre之后。
*/
public class L92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {  
        ListNode newHead = new ListNode(0);  
        newHead.next = head;  
          
        ListNode prevNode = getMthNode(newHead, m);  
        ListNode current = prevNode.next;  
        ListNode tail = prevNode.next;  
        int count = 1;  
          
        ListNode prev = null;  
        ListNode next = null;  
        //中间过程举例可得。
        while (count <= (n - m + 1)) {  
            next = current.next;  
            current.next = prev;  
            prev = current;  
            current = next;  
            count++;  
        }  
        prevNode.next = prev;  
        tail.next = next;          
          
        return newHead.next;  
    }  
      
    public ListNode getMthNode(ListNode newHead, int m) {  
        for (int i = 1; i < m; i++) {  
            newHead = newHead.next;  
        }  
        return newHead;  
    }  
//    
//    //思路：用头插法建立新链表
//  	private ListNode reverseList(ListNode head) {
//          if(head == null || head.next == null) return head;
//          ListNode newHead = head;
//          //下面两句话的顺序不能颠倒！如果颠倒，那么newHead和head会一起指向null 后面即无法执行，这里先保存出head.next 就没问题了。先打断，再连接。
//          ListNode cur = head.next;
//          newHead.next = null;
//          ListNode nxt = null;
//          while(cur != null) {
//          	nxt = cur.next;
//          	cur.next = newHead;
//          	newHead = cur;
//          	cur = nxt;
//          }
//          return newHead;
//      }
    
    public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
//    	ListNode node3 = new ListNode(3);
//    	ListNode node5 = new ListNode(5);
//    	node3.next = node5;
//    	node5.next = null;
    	
		L92 test = new L92();
		ListNode newHead = test.reverseBetween(node1, 2, 4);
		
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
