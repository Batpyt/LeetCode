package 树;
import java.util.*;

/**
 *
 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 示例：
 二叉树：[3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层序遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class Anhangdayin {
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		//新建队列，用来储存一层中的节点
		Queue<TreeNode> roots = new LinkedList<>();

		//若有根节点，将根节点记录至队列
		if(root != null) roots.add(root);

		//当还有节点-还没到底
		while(!roots.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int size = roots.size();
			//遍历一层的节点
			for(int i = 0; i < size; i++) {
				TreeNode node = roots.poll();
				//记录当前节点的值
				temp.add(node.val);

				//若当前节点还有左/右子树，将其加入队列
				if(node.left != null) roots.add(node.left);
				if(node.right != null) roots.add(node.right);
			}
			res.add(temp);
		}
		return res;
	}


	public void dfs(TreeNode root, List<List<Integer>> res, int level) {
		if(root == null) return;

		//遍历到了新的一层，res中添加一个新列表
		if(res.size() == level) {
			res.add(new ArrayList<>());
		}

		//在res对应层数的列表中加入当前节点的值
		res.get(level).add(root.val);
		//往下遍历，层数要加1
		dfs(root.left, res, level+1);
		dfs(root.right, res, level+1);
	}



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

    //倒序
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		LinkedList<List<Integer>> res = new LinkedList<>();
		if(root != null) queue.add(root);

		while(!queue.isEmpty()) {
			List<Integer> temp = new LinkedList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			res.addFirst(temp);
		}
		return res;
	}




}
