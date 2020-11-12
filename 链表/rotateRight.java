package 链表;
/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

示例 2:
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 实质为倒数第k个节点作为新的head生成新的链表
 * 先改为循环链表，然后定位到新的head处，再定位到尾部
 */
public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode n1 = head;
        int size = 1;
        //计算链表长度
        while(n1.next != null) {
            size++;
            n1 = n1.next;
        }
        //将链表改为环形
        n1.next = head;
        //计算新的head是倒数第几个
        int index = k > size ? k % size : k;
        //定位到新head
        ListNode newhead = head;
        for(int i = 0; i < size - index; i++) {
            newhead = newhead.next;
        }

        //定位到新尾巴也就是新head的前一个，将环打开
        while(head.next != newhead) {
            head = head.next;
        }
        head.next = null;
        return newhead;
    }
}
