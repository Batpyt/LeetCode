package 树;
import java.util.*;
/*
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
/*
 * 答题思路与前两题相同，多加一个对层数的判断。
 */

public class Anhangdayin_III {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if(root == null) {
			return res;
		}
		
		que.add(root);
		int count = 1;
		while(!que.isEmpty()) {
			LinkedList<Integer> temp = new LinkedList<>();
			int size = que.size();
			for(int i = 0; i < size; i++) {
				TreeNode t = que.poll();
				if(count % 2 != 0) {   //判断层数
					temp.addLast(t.val);
				}
				else if(count % 2 == 0) {
					temp.addFirst(t.val);
				}
				if(t.left != null) {
					que.add(t.left);
				}
				if(t.right != null) {
					que.add(t.right);
				}
			}
			count++;
			res.add(temp);
		}
		return res;
    }

}
