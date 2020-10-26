package 树;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  /*
  双层dfs
  两个递归：因为要回到上一步，而不是从头开始
   */
public class ListinTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;

        //从root开始递归，若当前节点不对，再遍历左右子树
        return isSubPathfromRoot(head, root) || isSubPath(head, root.right) || isSubPath(head, root.left);
    }

    public boolean isSubPathfromRoot(ListNode head, TreeNode root) {
        if(head == null) return true;//若链表遍历完了，返回true
        if(root == null) return false;//若链表还没完，树完了，返回false

        //当前树和链表节点的值相等，往左右两边继续遍历
        if(root.val == head.val) return isSubPathfromRoot(head.next, root.left) || isSubPathfromRoot(head.next, root.right);
        return false;
    }
}
