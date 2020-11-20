package 链表;

/**
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class insertSortList {
    /**
     * 新建新节点：dummy：dummy.next指向head，为了方便从head遍历
     * lastsort：指向最新一个排完序的节点
     * cur：指向正要排序的节点
     *
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastsort = head;
        //从head的下一个开始排序
        ListNode cur = head.next;

        while(cur != null) {
            //若要排序的节点比最后排完序的节点值大，直接将排完序的节点后移一位
            if(cur.val >= lastsort.val) {
                lastsort = lastsort.next;
            }
            //否则，从head开始往后遍历，
            else {
                //新建node节点，正要排序的节点值与node.next的节点值比较
                ListNode node = dummy;
                //往后遍历直到node.next比正要排序的节点值大
                while(node.next.val < cur.val) {
                    node = node.next;
                }
                //由于cur要向后移，提前将lastnode.next赋值
                lastsort.next = cur.next;
                //将cur添加到node后面
                cur.next = node.next;
                node.next = cur;
            }
            //将要排序的向后移
            cur = lastsort.next;
        }
        return dummy.next;
    }
}
