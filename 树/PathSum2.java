package 树;
import java.util.*;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PathSum2 {
    //一个用来储存要返回的链表
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    //用来记录路径的队列
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //开始递归
        dfs(root, sum);
        return res;
    }

    /**
     * 用来递归检测路径是否符合
     */
    public void dfs(TreeNode root, int sum) {
        //如果遍历完了根节点，返回
        if(root == null) return;

        //将当前节点的值加入路径队列
        path.addLast(root.val);
        //用目标数值减去节点值
        sum = sum - root.val;
        //若当前节点是根节点且目标已经减为0，将该路径记录
        if(root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<Integer>(path));
        }

        //递归检测该节点的子节点
        dfs(root.left, sum);
        dfs(root.right, sum);
        //将加入的节点删除
        path.removeLast();
    }




    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void d(TreeNode root, int sum) {
        if(root == null) return;
        sum = sum - root.val;
        path.addLast(root.val);
        if(root.left == null && root.right == null && sum == 0) res.add(new LinkedList<Integer>(path));
        d(root.left, sum);
        d(root.right, sum);
        path.removeLast();
    }
}
