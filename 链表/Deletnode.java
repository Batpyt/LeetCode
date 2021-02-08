package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
 
public class Deletnode {
    public ListNode deleteNode(ListNode head, int val) {
    	if(head.val == val) {
    		return head.next;
    	}
    	
    	ListNode pre = head;
    	ListNode now = head.next;
    	
    	while(now != null) {
    		if(now.val == val) {
    			pre.next = now.next;
    			break;
    		}
    		else {
    			now = now.next;
    			pre = pre.next;
    		}
    	}
        
    	return head;
    }

	public ListNode deleteNode2(ListNode head, int val) {
		ListNode h = head;
		if(head == null) return head;
		ListNode pre = null;
		if(head.val == val) {
			return head.next;
		}
		while(head != null) {
			if(head.next.val == val) {
				head.next = head.next.next;
				break;
			}
			head = head.next;
		}
		return h;
	}

	/*
	更优方法
	在链表前面添加一个dummyhead，直接从原链表的head开始遍历。
	 */
	public ListNode deleteNode23(ListNode head, int val) {
		if(head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while(cur.next != null) {
			if(cur.next.val == val) {
				cur.next = cur.next.next;
				break;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
