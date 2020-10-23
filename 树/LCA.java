package 树;
/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 */

/*
先知道左右子树的状况，然后一级一级往上返回
 */
public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //null表示遍历到了叶节点，为p或q表示遍历到pq，返回当前节点。
        if(root == null || root == p || root == q) return root;

        //左右遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;//左右都存在，pq都出现了，当前为最小公共祖先
        else if(left != null) return left;//右边是空的返回左边
        else if(right != null) return right;//左边是空的返回右边
        return null;
    }
}
