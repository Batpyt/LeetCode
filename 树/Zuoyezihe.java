package 树;
/*
计算给定二叉树的所有左叶子之和。
 */
public class Zuoyezihe {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res = root.left.val;
        }

        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res = root.left.val;
        }

        return res + sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
    }

    public boolean isLeaf(TreeNode node) {
        return true;
    }

}


