package 树;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinAbsoluteDifference {
	int min = Integer.MAX_VALUE;
	TreeNode pre = null;
	public int getMinimumDifference(TreeNode root) {
		getMin(root);
		return min;
	}

	/*
	中序遍历，每次计算差值，比较大小
	 */
	public void getMin(TreeNode root) {
		if(root == null) return;
		getMin(root.left);
		if(pre != null) min = Math.min(min, Math.abs(pre.val - root.val));
		pre = root;
		getMin(root.right);
	}
}
