package 树;
import java.util.*;
/*
您需要在二叉树的每一行中找到最大的值。

示例：

输入:

          1
         / \
        3   2
       / \   \
      5   3   9

输出: [1, 3, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * BFS，用队列记录每一层的节点。
 */

public class LargestValueinEachRow {
    public List<Integer> largestValues(TreeNode root) {
        //if(root == null) return null;

        //队列用来记录每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        //记录根节点
        if(root != null) queue.add(root);

        //直到遍历到最底端的根节点
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;

            //遍历该层的节点
            int levelsize = queue.size();
            for(int i = 0; i < levelsize; i++) {
                //获取队列中节点和节点的值，并于最大值比较
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                //若有左右子节点，插入队列中
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
