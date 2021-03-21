package 链表;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 分别生成奇数位置链表和偶数位置链表
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        int index = 0;
        ListNode oddhead = head;
        //奇数位置的节点
        ListNode odd = head;

        //偶数链表的起点
        ListNode evenhead = head.next;
        //偶数位置的节点
        ListNode even = head.next;
        //遍历链表
        while(even != null && even.next != null) {
            //even.next就是下一个奇数位置节点，将odd.next指向他的next
            odd.next = even.next;
            //将odd指向下一个奇数位
            odd = odd.next;

            //odd已经指向下一个奇数位置，所以他的下一个是下一个偶数位置，将even.next指向他的next
            even.next = odd.next;
            //even指向下一个偶数位
            even = even.next;
        }
        //将两个链表接到一起
        odd.next = evenhead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

    public ListNode oddEvenList3(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}
