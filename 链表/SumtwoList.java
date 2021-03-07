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

    /**
     *
     给定两个用链表表示的整数，每个节点包含一个数位。

     这些数位是反向存放的，也就是个位排在链表首部。

     编写函数对这两个整数求和，并用链表形式返回结果。



     示例：

     输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     输出：2 -> 1 -> 9，即912
     进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?

     示例：

     输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     输出：9 -> 1 -> 2，即912
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //用来记录进位的变量
        int carry = 0;
        //dummy head
        ListNode res = new ListNode(0);
        //真正的结果起始位置
        ListNode cur = res;

        //当l1，l2都遍历完再跳出循环
        while (l1 != null || l2 != null) {
            //记录l1/l2的值
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            //当前两个数的和
            int sum = n1 + n2 + carry;
            //记录进位和当前和的个位数
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);

            //将l1，l2，结果向后移
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        //若还有进位，记录
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return res.next;
    }
}
