package 树;

import java.util.*;

public class NTreeLevelOrder {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		//记录每一层的节点
		List<Node> rootlist = new ArrayList<>();
		//记录节点们
		LinkedList<List<Node>> queue = new LinkedList<>();
		rootlist.add(root);
		queue.add(rootlist);

		while(queue.size() > 0) {
			List<Integer> num = new ArrayList<>();
			int size = queue.size();
			//记录这一层的数并将他们下一层的子节点记录
			for(int i = 0; i < size; i++) {
				List<Node> nodes = queue.removeFirst();
				//二叉树情况下这里for循环为left和right即可
				for(Node node : nodes) {
					num.add(node.val);
					//记录子节点
					if(node.children != null) {
						queue.addLast(node.children);
					}
				}
			}
			if(num.size() > 0) {
				res.add(num);
			}
		}
		return res;
	}
}
