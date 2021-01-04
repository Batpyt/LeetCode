package 链表;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
将小于x和大于等于x的节点分别储存在两个链表中
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        //两个dummyhead
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        //两个链表
        ListNode n1 = dummy1;
        ListNode n2 = dummy2;
        //遍历原始链表
        while(head != null) {
            //若小于x，存到n1中
            if(head.val < x) {
                n1.next = head;
                head = head.next;
                n1 = n1.next;
                n1.next = null;
            }
            //大于
            else {
                n2.next = head;
                head = head.next;
                n2 = n2.next;
                n2.next = null;
            }
        }
        //将两个链表怕拼接到一起
        n1.next = dummy2.next;
        return dummy1.next;
    }
}
