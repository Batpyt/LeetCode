package 链表;

/*
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
/*
 * 双指针，一个指向l1一个l2.
 */
public class Hebingpaixushuzu {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode res = new ListNode(0); //设定一个无用的节点，在其后面接l1和l2的节点
    	ListNode cur = res;
    	
    	while(l1 != null && l2 != null) {  //若l1或者l2遍历到尾部了就跳出
    		if(l1.val < l2.val) { //若l1的小于l2，将l1的节点接到cur后面
    			cur.next = l1;
    			cur = cur.next;
    			l1 = l1.next;
    		}
    		else {  //其他情况接l2
    			cur.next = l2;
    			cur = cur.next;
    			l2 = l2.next;
    		}
    	}
    	if(l1 == null) {
    		cur.next = l2;  //将剩下的没接完的接入
    	}
    	else {
    		cur.next = l1;
    	}
    	
    	return res.next;
    }

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode cur = res;

		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			}
			else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}

		if(l1 != null) {
			cur.next = l1;
		}
		else {
			cur.next = l2;
		}
		return res.next;
	}

}
