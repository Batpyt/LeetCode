package 链表;

public class FanzhuanBufenLianbiao {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(head == null) return head;
		ListNode cur = head, pre = null;
		//先定位到要反转的链表首部
		//cur第一个需要反转的节点，pre为其上一个节点
		while(left > 1) {
			pre = cur;
			cur = cur.next;
			left--;
			right--;
		}
		//然后开始反转，原理与反转链表1相同
		ListNode next = null;
		//用两个节点记录第一对pre和cur的位置
		//con为反转链表首部的前一个节点，为正常链表的最后一个节点
		//tail为反转链表首部
		ListNode con = pre, tail = cur;
		while(right > 0) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			right--;
		}
		//反转完毕后，pre指向的是反转完毕后的反转部分链表首部
		//cur指向的是下一个正常链表的节点
		//tail指向的变为了反转完毕后的链表尾部

		//然后将反转后的链表头部接到正常链表
		//若con不是null。也就是不是从第一个节点开始反转，将con.next设为反转完毕后的链表首部：pre
		if(con != null) {
			con.next = pre;
		}
		//若是从第一个节点直接反转的，head直接指向反转完毕后的链表首部
		else {
			head = pre;
		}
		//此时cur为下一个正常节点，tail.next指向该正常节点
		tail.next = cur;
		return head;
	}





	//思路：head表示需要反转的头节点，pre表示需要反转头节点的前驱节点
	//我们需要反转n-m次，我们将head的next节点移动到需要反转链表部分的首部，需要反转链表部分剩余节点依旧保持相对顺序即可
	//比如1->2->3->4->5,m=1,n=5
	//第一次反转：pre->1(head) 2(next) 3 4 5 反转为 2 1(head) 3(nex.next) 4 5
	//第二次反转：2 1(head) 3(next) 4 5 反转为 3 2 1 4 5
	//第三次发转：3 2 1(head) 4(next) 5 反转为 4 3 2 1 5
	//第四次反转：4 3 2 1(head) 5(next) 反转为 5 4 3 2 1
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;

		for(int i = 1; i < m; i++){
			pre = pre.next;
		}
		//pre为head前一个节点，为翻转部分首部,前驱节点
		head = pre.next;
		for(int i = m; i < n; i++){

			ListNode nex = head.next;
			//head节点指向next后一位，意味着head往后移一位
			head.next = nex.next;
			//
			nex.next = pre.next;
			pre.next = nex;
		}
		return dummy.next;
	}
}
