package DFS;

import 链表.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。根节点的值为 5 ，但是其右子节点值为 4 。

 */
/*
中序遍历，将数值储存到栈中，检测是否是递增栈。
 */

public class Yanzhengershasousuoshu {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static Deque<Integer> stack = new LinkedList<>();  //全局变量栈
    public static boolean isValidBST(TreeNode root) {
        int[] num = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            num[i] = stack.pop();
            i++;
        }
        for(int j = 1; j < num.length; j++) {
            if(num[i] > num[i - 1]) return false;
        }
        return true;
    }

    public static void inOrder(TreeNode treeNode) {
        if(treeNode == null) return;
        else {
            inOrder(treeNode.left);
            stack.push(treeNode.val);  //中序遍历
            inOrder(treeNode.right);
        }
    }

}
