package 链表;

import java.util.List;
import java.util.Stack;
/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SumtwoList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 用两个栈记录两个链表中的值
         */
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }

        /**
         * carry表示是否进位
         * 当栈中有值或者有进位，则继续循环
         */
        int carry = 0;
        ListNode head = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            //计算当前节点的值
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + carry;
            //新建一个节点
            ListNode n = new ListNode(sum % 10);
            //这两部是将该节点加入已有链表的前面作为头部
            n.next = head;
            head = n;
            carry = sum / 10;
        }
        return head;
    }
}
