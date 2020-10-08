package 树;

import javafx.geometry.Pos;

import java.util.*;

//后续遍历，左-右-根
public class postOrder {
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[3];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 3; i++) {
            node[i] = new TreeNode(i);
        }
        node[0].left = node[1];
        node[0].right = node[2];
        node[0].val = 2;
        node[1].val = 1;
        node[2].val = 3;
        //   2
        // 1   3
        Postorder(node[0]);
        System.out.println();
        //Preorder(node[0]);
    }

    List<Integer> res;
    public static void Postorder(TreeNode treeNode) {
        if(treeNode == null) return;
        else {
            Postorder(treeNode.left);
            Postorder(treeNode.right);
            System.out.println(treeNode.val);
        }
    }

    public static void postorder(TreeNode treeNode) {
        int left = 1;  //用来记录当前是左子节点还是右子节点
        int right = 2;
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> helper = new LinkedList<>();  //辅助栈，记录是左还是右子节点
        while(treeNode != null || !stack.isEmpty()) {
            while(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
                helper.push(left);
            }
            while(!stack.isEmpty() && helper.peek() == right) {  //若是从右子节点返回的父节点，任务完成，弹出两个栈的栈顶
                helper.pop();
                System.out.println(stack.pop().val);
            }
            if(!stack.isEmpty() && helper.peek() == left) {  //若是从左子树返回的，将栈顶改为right。
                helper.pop();
                helper.push(right);
                treeNode = treeNode.right;
            }
        }
    }

}
