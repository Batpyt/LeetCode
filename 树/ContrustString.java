package 树;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContrustString {
	public String tree2str(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		buildString(t, sb);
		return sb.toString();
	}

	public void buildString(TreeNode root, StringBuilder sb) {
		if(root == null) return;
		//将值加入
		sb.append(root.val);
		//当左或者右有值
		if(root.left != null || root.right != null) {
			//将左子树加入
			sb.append("(");
			buildString(root.left, sb);
			sb.append(")");
			//若有右子树再加入右子树
			if(root.right != null) {
				sb.append("(");
				buildString(root.right, sb);
				sb.append(")");
			}
		}
	}
}
