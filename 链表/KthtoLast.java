package 链表;
/*
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：

输入： 1->2->3->4->5 和 k = 2
输出： 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthtoLast {
    /*
    快慢指针，快指针先走k，慢的再走
     */
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for(int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

}
