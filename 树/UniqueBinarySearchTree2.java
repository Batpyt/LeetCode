package 树;

import java.util.*;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class UniqueBinarySearchTree2 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();
		if(n == 0) return res;
		return generate(1, n);
	}

	/**
	 * 在start和end的范围内生成二叉搜索树
	 * @param start
	 * @param end
	 * @return
	 */
	public List<TreeNode> generate(int start, int end) {
		List<TreeNode> allTrees = new ArrayList<>();
		if(start > end) {
			allTrees.add(null);
			return allTrees;
		}

		//i为根节点，在i的左右生成左右子树
		//每个数都做一次根节点
		for(int i = start; i <= end; i++) {
			//获得所有可能的左右子树集合
			List<TreeNode> left = generate(start, i - 1);
			List<TreeNode> right = generate(i + 1, end);
			//从左右集合中选出子树拼接到根节点中
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					//i为根节点
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					allTrees.add(root);
				}
			}
		}
		return allTrees;
	}
}
