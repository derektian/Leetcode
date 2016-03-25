/*L61 Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
tags：Linked List, Two Pointers
Similar Problems: rotate array
*/
/*
思路1：正常思路即可，找到最后一个结点和倒数第二个结点，最后一个节点接到头，倒数第二个结点next为null
思路2：只关注头尾结点，不需要每次移动元素，只需要找到拼接的结点，移动一次即可。
坑：head上来直接为null的情况；head只有一个元素的情况(因为用了do while寻找倒数结点直接报错)；k值很大的问题；
链表中结点的更新结点。
*/
public class L61 {
/*  //思路1	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode countNode = head;
        int count = 0;
        while(countNode != null) {
        	countNode = countNode.next;
        	count++;
        }
        
        k = k % count;
        
        ListNode tail = head;
        for(int i = 0; i < k; i++) {
        	ListNode p = new ListNode();
        	//更新头结点
        	ListNode begin = tail;
        	do {
        		p = tail;
        		tail = tail.next;
        	} while(tail.next != null);
        	
        	tail.next = begin;
        	p.next = null;
        }
        head = tail;
		return head;
    }
*/	
	//思路2
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0) return head;
        
		ListNode countNode = head, tail = head;
		
        int length = 0;
        while(countNode != null) {
        	length++;
        	tail = countNode;
        	countNode = countNode.next;
        }
        k = k % length;
		
        countNode = head;
        for (int i = 0; i < length - k - 1; i++) {
			countNode = countNode.next;
		}
        tail.next = head;
        head = countNode.next;
        countNode.next = null;
        
		return head;
	}
	
	
	
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
		
		L61 test = new L61();
		
		ListNode result = new ListNode();
		
		result = test.rotateRight(node1, 2);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		
	}
}
