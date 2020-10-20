package 链表;

import java.util.*;
/*
 * 
 */

public class Huanxing {
	public static boolean hasCycle(ListNode head) {
		Set<ListNode> map = new HashSet<>();
		ListNode temp = head;
		
		while(temp != null) {
			if(map.contains(temp)) {
				return true;
			}
			map.add(temp);
			temp = temp.next;
		}
		return false;
		
	}

	/*
	快慢指针
	 */
	public static boolean hasCycle2(ListNode head) {
		ListNode slow = head, fast = head;

		while(true) {
			if(fast == null || fast.next == null) return false;
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
	}
	

}
