package 树;

import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class KSmallest {
	public int kthSmallest(TreeNode root, int k) {
		Stack<Integer> stack = new Stack<>();
		inorder(root, stack, k);
		return stack.peek();
	}

	//中序遍历，记录在栈中，栈的大小=k时返回栈顶
	public void inorder(TreeNode root, Stack<Integer> stack, int k) {
		if(root == null) return;

		inorder(root.left, stack, k);
		if(stack.size() == k) return;
		stack.push(root.val);
		inorder(root.right, stack, k);
	}
}
