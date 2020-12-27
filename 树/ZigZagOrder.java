package 树;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZigZagOrder {
    //dfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }

    /*
    每次判断当前层数奇偶
     */
    public void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return ;

        //当遍历到一个新的层数，增加一个新sublist
        if(res.size() == level) {
            res.add(new LinkedList<Integer>());
        }

        //如果是偶数层，正序
        if(level % 2 == 0) {
            res.get(level).add(root.val);
        }
        //奇数层，倒序
        else{
            res.get(level).add(0, root.val);
        }

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}
