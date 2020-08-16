package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 
public class Deletnode {
    public ListNode deleteNode(ListNode head, int val) {
    	if(head.val == val) {
    		return head.next;
    	}
    	
    	ListNode pre = head;
    	ListNode now = head.next;
    	
    	while(now != null) {
    		if(now.val == val) {
    			pre.next = now.next;
    			break;
    		}
    		else {
    			now = now.next;
    			pre = pre.next;
    		}
    	}
        
    	return head;
    }
}
