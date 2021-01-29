package 树;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) return false;
		//遍历s的子节点，每个都判断和t是否一样
		return isSubtree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	/*
	判断从s和t为根节点开始的树是否相同
	 */
	public boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		if(s.val != t.val) return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
}
