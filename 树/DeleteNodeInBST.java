package 树;

public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;

		//要删除的在左边
		if(root.val > key) {
			root.left = deleteNode(root.left, key);
			return root;
		}
		//要删除的在右边
		if(root.val < key) {
			root.right = deleteNode(root.right, key);
			return root;
		}
		//定位到了要删除的
		if(root.val == key) {
			if(root.left == null) return root.right;
			if(root.right == null) return root.left;
			else {
				//删除当前节点后替换他的新节点
				TreeNode successor = minLeft(root.right);
				successor.right = deleteMin(root.right);
				successor.left = root.left;
				return successor;
			}
		}
		return root;
	}

	//某节点开始的最小左子树
	private TreeNode minLeft(TreeNode node) {
		if(node.left == null) {
			return node;
		}
		return minLeft(node.left);
	}

	//某节点开始的第一个没有左子树的节点的右子树节点
	private TreeNode deleteMin(TreeNode node) {
		if(node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		return node;
	}
}
