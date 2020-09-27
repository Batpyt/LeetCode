package 树;
/*
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 */
/*
利用二叉搜索树性质。根左边都小于根，右边都大于根。从上往下判断，pq都小于根的话去左子树，都大于的话右子树，不然跳出循环返回当前根节点
 */

public class Zuijinzuxian {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while(true) {
            if(res.val < p.val && res.val < q.val) res = res.right;
            if(res.val > p.val && res.val > q.val) res = res.left;
            else break;
        }
        return res;
    }
}
