package 树;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BottomLeft {
	int max = Integer.MIN_VALUE;
	int res;
	public int findBottomLeftValue(TreeNode root) {
		dfs(root, 0);
		return res;
	}

	/**
	 *
	 * @param root
	 * @param depth 记录深度
	 */
	public void dfs(TreeNode root, int depth) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			if(depth > max) {
				max = depth;
				res = root.val;
			}
		}
		dfs(root.left, depth+1);
		dfs(root.right, depth+1);

	}
}
