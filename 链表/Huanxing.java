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
	

}
