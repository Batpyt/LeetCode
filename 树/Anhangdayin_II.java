package 树;

import java.util.*;
/*
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * [
  [3],
  [9,20],
  [15,7]
]
 */
/*
 * 总体思路和 Anhangdayin一样，只不过要每一行打印一阶。
 * 用que.size来控制。
 */

public class Anhangdayin_II {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		
		que.add(root);
		while(!que.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int size = que.size();
			for(int i = 0; i < size; i++) {
				TreeNode t = que.poll();
				temp.add(t.val);
				if(t.left != null) {
					que.add(t.left);
				}
				if(t.right != null) {
					que.add(t.right);
				}
			}
			res.add(temp);
		}
		
		return res;
    }

}
