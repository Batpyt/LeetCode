package 链表;

/*
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
 * 遍历法
 */
public class Fanzhuanlianbiao {
	public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        
        while(head != null) {
        	next = head.next;
        	head.next = pre;
        	pre = head;
        	head = next;
        }
        
		
		return pre;
    }
	
	/*
	 * 每对节点两两倒转
	 */
	public ListNode reversList2(ListNode head) {
		//三个变量实现两两倒转
		ListNode pre = null;  //原数组正处理的节点
		ListNode temp = null; //暂时节点，储存正处理节点原本的下一个节点
		ListNode cur = head;  //正处理的节点，从head开始
		
		while(cur != null) {
			temp = cur.next; //给暂时节点赋值正处理节点原本的下一个节点
			cur.next = pre;  //实现倒转
			
			//pre和cur都往后移一位
			pre = cur;       
			cur = temp;
			
		}
		
		return pre;
	}


	public ListNode reversL(ListNode head) {
		ListNode pre = null, cur = head, next = null;
		/*
		null -> 1 -> 2 -> 3
		pre    cur   next
		 */
		while(cur != null) {
			//注意变量转移的先后顺序
			//先赋值next为当前节点的next，再将cur.next指向pre
			next = cur.next;
			cur.next = pre;

			//下面为下一循环要用到的变量
			//当前的cur作为下一循环的pre，之前赋值的next作为下一循环的cur
			pre = cur;
			cur = next;
		}
		return pre;
	}

}
