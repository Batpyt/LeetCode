package 树;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxPathSum {
	private int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		getMax(root);
		return res;
	}

	public int getMax(TreeNode root) {
		if(root == null) return 0;
		//取左右子树的最大值
		int left = Math.max(0, getMax(root.left));
		int right = Math.max(0, getMax(root.right));

		//当左右都是0的话，这样也可以取当前值
		//将当前最大路径和记录
		res = Math.max(res, left + right + root.val);

		//返回当前节点的最大路径和
		return Math.max(left, right) + root.val;
	}
}
