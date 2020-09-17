package 树;
/*
给定一个二叉树，检查它是否是镜像对称的。
 */
/*
左子树的左子节点要等于右子树的右子节点。
左子树的右子节点要等于右子树的左子节点。
 */
public class Duichenshu {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        //从跟节点的左右子树开始遍历
        return isDuichen(root.left, root.right);
    }

    public static boolean isDuichen(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;  //若左右节点没有同时到达叶子节点，或者值不一样，则返回false。

        //左子树的左子节点要等于右子树的右子节点。
        //左子树的右子节点要等于右子树的左子节点。
        return isDuichen(left.left, right.right) && isDuichen(left.right, right.left);
    }
}
