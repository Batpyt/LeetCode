package 树;

import java.util.*;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *  
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MosrFrequentSubtreeSum {
	int max = Integer.MIN_VALUE;
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		dfs(root, map);
		List<Integer> list = new ArrayList<>();
		//统计出现次数为最大次数的
		for(int key : map.keySet()) {
			if(map.get(key) == max) {
				list.add(key);
			}
		}

		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	/**
	 *
	 * @param root
	 * @param map 记录子树和和其出现次数
	 * @return
	 */
	public int dfs(TreeNode root, Map<Integer, Integer> map) {
		if(root ==null) return 0;
		int left = dfs(root.left, map);
		int right = dfs(root.right, map);
		//将和加入map中，并判断是否最大出现次数
		int sum = left + right + root.val;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		max = Math.max(max, map.get(sum));
		return sum;
	}
}
