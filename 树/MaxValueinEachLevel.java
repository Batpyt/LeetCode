package 树;

import java.util.*;

/**
 *
 您需要在二叉树的每一行中找到最大的值。

 示例：

 输入:

 1
 / \
 3   2
 / \   \
 5   3   9

 输出: [1, 3, 9]
 */
public class MaxValueinEachLevel {
	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> level = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		level.add(root);
		while(!level.isEmpty()) {
			int max = Integer.MIN_VALUE;
			int size = level.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = level.poll();
				max = Math.max(max, node.val);
				if(node.left != null) level.add(node.left);
				if(node. right != null) level.add(node.right);
			}
			res.add(max);
		}
		return res;
	}
}
