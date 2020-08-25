package 链表;
/*
 * 输入两个链表，找出它们的第一个公共节点。
 */
/*
 * 双指针
 * 建立两个节点来遍历两个链表。
 * 当一个节点遍历到链表尾部的时候，将节点指向另一条链表的表头。
 * 直到两个节点相同。
 */

public class Xiangjiao {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode n1 = headA;
		ListNode n2 = headB;
		ListNode res = null;
		if(headA == null || headB == null){
            return null;
        }
		
		while(true) {
			if(n1 == n2) {
				res = n1;
				break;
			}
			if(n1 == null || n2 == null) {
				if(n1 == null) {
					n1 = headA;
					n2 = n2.next;
				}
				if(n2 == null) {
					n2 = headB;
					n1 = n1.next;
				}
			}
			else {
				n1 = n1.next;
				n2 = n2.next;
			}
			
			
		}
		
		return res;
	}

}
