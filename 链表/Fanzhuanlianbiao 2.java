package 链表;

/*
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
/*
 * 遍历法
 */
public class Fanzhuanlianbiao {
	public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        
        while(head != null) {
        	next = head.next;  //先储存下一个节点
        	head.next = pre;  //将该节点的下一个指向上一个
        	pre = head;  //下一个要处理节点的上一个就是该节点
        	head = next;  //要处理的节点后一一个
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

}
