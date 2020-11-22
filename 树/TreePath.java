package 树;
import java.util.*;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        //深度优先搜索，每次往下传递的参数是下一个节点，当前路径和所有路径
        buildPath(root, "", paths);
        return paths;
    }

    public void buildPath(TreeNode root, String path, List<String> paths) {
        if(root == null) return;
        if(root != null) {
            //stringbuilder将当前路径继承，改动基于当前路径
            StringBuilder sb = new StringBuilder(path);
            //将当前节点值记录到当前路径
            sb.append(Integer.toString(root.val));
            //若已经是跟节点，将当前路径记录到所有路径中
            if(root.left == null && root.right == null) {
                paths.add(sb.toString());
            }
            //如果不是，继续往下遍历
            else {
                sb.append("->");
                buildPath(root.left, sb.toString(), paths);
                buildPath(root.right, sb.toString(), paths);
            }
        }
    }
}
