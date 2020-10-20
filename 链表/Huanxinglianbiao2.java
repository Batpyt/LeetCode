package 链表;
/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
/*
快慢指针。慢指针一次往前一个，快指针一次两个。
若链表为环形，两指针必定相遇，若快指针遍历到链表尾，则没有环。

一个指针从相遇处往后遍历，另一个从head开始遍历，相遇处即为环的起始点。
 */

public class Huanxinglianbiao2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(true) {
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast =  fast.next.next;
            if(slow == fast) break;
        }

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
