package 链表;

import java.util.HashMap;
/*
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
/*
 * 用一个hasmap实现。key是原链表，value是新链表。
 */
public class Fuzalianbiao {
	public Node copyRandomList(Node head) {
        Node cur = head;
        HashMap<Node, Node> res = new HashMap<>();
        
        while(cur != null) {
        	res.put(cur, new Node(cur.val)); //先将原链表存为key，每个节点的值存入新建的节点。
        	cur = cur.next;
        }
        cur = head;
        while(cur != null) {
        	res.get(cur).random = res.get(cur.random);  //get(cur)得到的是对应原链表处新链表的节点，get(cur.random)得到的是对应原链表处的节点对应的random节点。
        	res.get(cur).next = res.get(cur.next);  //next同理。
        	cur = cur.next;
        }
        
        return res.get(head);
    }

}
