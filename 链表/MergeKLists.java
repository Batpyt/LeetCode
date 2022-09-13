package 链表;

public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        ListNode head = lists[0];
        for(int i = 1; i < size; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode res = null;
        res.next = head;
        while(true) {
            if(node1 == null) {
                head = node2;
                break;
            }
            if(node2 == null) {
                head = node1;
                break;
            }
            if(node1.val > node2.val) {
                head = node1;
                //head.next = merge(head.next, node2);
            }
            else {
                head = node2;
                //head.next = merge(node1, head.next);
            }
        }
        return head;
    }

}
