package 树;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 *
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 *
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 *
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 *
 * 示例 1:
 *
 * 输入:
 * 二叉树如下所示:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 *
 * d = 2
 *
 * 输出:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddOneRow {
	public TreeNode addOneRow(TreeNode t, int v, int d) {
		//若加在根节点，直接新建根节点，把原树加入左子树
		if(d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = t;
			return node;
		}
		insertTree(t,1, d, v);
		return t;
	}

	public void insertTree(TreeNode root, int dept, int d, int v) {
		if(root == null) return;
		//若下一层为要加入的一层
		if(dept == d - 1) {
			//先记录下下层
			TreeNode temp = root.left;
			//下层加入目标
			root.left = new TreeNode(v);
			//下下层接上
			root.left.left = temp;

			temp = root.right;
			root.right = new TreeNode(v);
			root.right.right = temp;
		}
		else {
			insertTree(root.left, dept + 1, d, v);
			insertTree(root.right, dept + 1, d, v);
		}
	}
}
