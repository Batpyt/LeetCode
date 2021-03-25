package 链表;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode dummy = new ListNode(1);
		//dummy head，用来处理 1 1 1 2 3 的情况
		dummy.next = head;
		ListNode pre = dummy;
		/*
		[1,2,3,3,4,4,5]
		 */
		while(pre.next != null && pre.next.next != null) {
			//若后两个值相等
			if(pre.next.val == pre.next.next.val) {
				int temp = pre.next.val;
				//往后遍历直到下一个的值不等于那两个相等的值
				while(pre.next != null && pre.next.val == temp) {
					pre.next = pre.next.next;
				}
			}
			//若不相等，直接后移
			else {
				pre = pre.next;
			}
		}
		return dummy.next;
	}

	/**
	 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	 */
	public ListNode deleteDuplicates1(ListNode head) {
		if(head == null) return head;
		ListNode cur = head;
		while(cur != null && cur.next != null) {
			if(cur.val == cur.next.val) {
				int temp = cur.val;
				while(cur.next != null && cur.next.val == temp) {
					cur.next = cur.next.next;
				}
			}
			else {
				cur = cur.next;
			}
		}
		return head;
	}
}
