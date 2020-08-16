package 树;
import java.util.*;
/*
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
/*
 * 用BFS方法，广度优先遍历。用一个队列来储存一个节点的左右子节点，一个arraylist来储存节点的值。
 */
public class Anhangdayin {
	public int[] levelOrder(TreeNode root) {
		if(root == null) {
			return new int[0];
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);  //先储存根节点
		
		while(!que.isEmpty()) {
			TreeNode temp = que.poll();  //将第队列第一个节点从队列中弹出
			res.add(temp.val);  //记录该节点的数值
			if(temp.left != null) {  //将该节点的左子树压入队列
				que.add(temp.left);
			}
			if(temp.right != null) {  //右子树压入队列
				que.add(temp.right);
			}
		}
		
		int[] ans = new int[res.size()];
		for(int i = 0; i < ans.length; i++) {
			ans[i] = res.get(i);
		}
		
		
		
		
		return ans;
    }

}
