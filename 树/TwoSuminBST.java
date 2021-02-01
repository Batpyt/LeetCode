package 树;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoSuminBST {
	Set<Integer> set = new HashSet<>();
	public boolean findTarget(TreeNode root, int k) {
		//只有一个值的时候直接false
		if(root.left == null && root.right == null) {
			return false;
		}
		preorder(root);
		for(int i : set) {
			if(set.contains(k - i)) {
				//防止6，3的情况
				if(k - i != i) return true;
			}
		}
		return false;
	}

	public void preorder(TreeNode root) {
		if(root == null) return;
		set.add(root.val);
		preorder(root.left);
		preorder(root.right);
	}
}
