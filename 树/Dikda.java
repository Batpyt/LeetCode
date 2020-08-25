package 树;
/*
给定一棵二叉搜索树，请找出其中第k大的节点。
 */
/*
二叉搜索树的中序遍历是递增序列，通过逆中序遍历就能得到第k大。
逆序中序遍历：右根左
每次遍历到一个值都k--，直到k为0
 */

public class Dikda {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        if(k == 0) {
            return;
        }
        if(--k == 0){
            res = root.val;
        }
        dfs(root.left);
    }
}
