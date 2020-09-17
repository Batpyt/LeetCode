package 树;

import java.util.Deque;
import java.util.LinkedList;

//中序遍历，左-根-右
public class InOrder {
    static Deque<Integer> s = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[5];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 5; i++) {
            node[i] = new TreeNode(i);
        }
        node[0].val = 1;
        node[1].val = 5;
        node[2].val = 4;
        node[3].val = 3;
        node[4].val = 6;
        node[1].left = node[0];
        node[1].right = node[2];
        node[2].left = node[3];
        node[2].right = node[4];

        //   2
        // 1   3
        inOrder(node[1]);
        System.out.println();
        Inorder(node[1]);
        System.out.println(isValidBST(node[0]));
    }
    //递归实现
    public static void inOrder(TreeNode treeNode) {
        if(treeNode == null) return;
        else {
            inOrder(treeNode.left);
            System.out.println(treeNode.val);
            s.push(treeNode.val);
            inOrder(treeNode.right);
        }
    }

    //非递归实现
    public static void Inorder(TreeNode treeNode) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(treeNode != null || !stack.isEmpty()) {
            while(treeNode != null) {  //当前节点有值时
                stack.push(treeNode);  //当前节点入栈
                treeNode = treeNode.left;  //遍历左子树，当是叶子节点时跳出循环
            }
            if(!stack.isEmpty()) {  //当栈中有节点
                treeNode = stack.pop();  //出栈
                System.out.println(treeNode.val);  //打印出栈的节点值。
                treeNode = treeNode.right;  //遍历右子树。若没有右子树，则不会经历上面的循环，直接到该if判断然后弹出父节点。
            }
        }

    }

    public static boolean isValidBST(TreeNode root) {
        int[] num = new int[s.size()];
        int i = num.length - 1;
        while(!s.isEmpty()) {
            num[i] = s.pop();
            i--;
        }
        for(int j = 1; j < num.length; j++) {
            //System.out.println(num[j]);
            if(num[j - 1] >= num[j]) return false;
        }
        return true;
    }

}
