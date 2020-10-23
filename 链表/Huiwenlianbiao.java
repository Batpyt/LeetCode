package 链表;
/*
请判断一个链表是否为回文链表。
 */

public class Huiwenlianbiao {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null || head.next == null) {
            return true;
        }

        while(fast.next != null && fast.next.next != null) { //通过快慢指针找到中点
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow.next);
        while(slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) { //从中点处反转链表
        if(head.next == null) return head;
        ListNode newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
