package 链表;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        /*
        用hashmap将节点和节点值储存，
         */
        Node node = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while(node != null) {
            ////get(node)得到的是对应原链表处新链表的节点，get(node.random)得到的是对应原链表处的节点对应的random节点。
            map.get(node).random = map.get(node.random);
            map.get(node).next = map.get(node.next);
            node = node.next;
        }
        return map.get(head);
    }
}
