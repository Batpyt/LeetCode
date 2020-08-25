package 树;
/*
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
/*
通过递归函数遍历左右子树，若深度相差大于1，则返回-1，若不是，则返回较大的深度+1。
 */

public class Pingheng {
    public boolean isBalanced(TreeNode root) {
        if(recur(root) == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public int recur(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = recur(root.left);
        if(left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if(right == -1) {
            return -1;
        }
        if(Math.abs(left - right) >= 2) {
            return -1;
        }
        else{
            return Math.max(left, right) + 1;
        }
    }
}
