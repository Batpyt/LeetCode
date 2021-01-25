package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		List<List<Integer>> lists = new ArrayList<>();
		dfs(root, lists, 0);
		//拿出每行的最后一个元素
		for(List<Integer> list : lists) {
			res.add(list.get(list.size() - 1));
		}
		return res;
	}

	/**
	 * 常规先按行记录
	 * @param root
	 * @param lists
	 * @param level
	 */
	public void dfs(TreeNode root, List<List<Integer>> lists, int level) {
		if(root == null) return;

		if(lists.size() == level) {
			lists.add(new ArrayList<>());
		}

		lists.get(level).add(root.val);

		dfs(root.left, lists, level+1);
		dfs(root.right, lists, level+1);
	}
}
