package 树;
/*
给定两个二叉树，编写一个函数来检验它们是否相同。
 */
public class Xiangtongdeshu {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;  //当同时到底，返回true
        if(p == null || q == null) return false;  //当某一棵树到子节点了另一个却没到，必然不同

        //返回该节点处两棵树的值是否相等，以及左右子树是否分别相同的结果
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
