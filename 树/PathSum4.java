package 树;

/**
 * 这颗二叉树一共有两条路径，
 * 根节点到叶子节点的路径 1\to 21→2 用数字\ 12 12 代替
 * 根节点到叶子节点的路径 1\to 31→3 用数字\ 13 13 代替
 * 所以答案为\ 12+13=25 12+13=25
 */

public class PathSum4 {
    public int sumNumbers(TreeNode root) {
        return fun(root, 0);
    }
    public static int fun(TreeNode root, int sum) {
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) return sum;
        return fun(root.left, sum) + fun(root.right, sum);
    }
}
