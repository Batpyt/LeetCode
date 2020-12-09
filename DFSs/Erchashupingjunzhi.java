package DFSs;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
示例 1：
输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
 */
/*
利用dfs，把每层的和以及节点的个数储存起来，再进行计算
 */

public class Erchashupingjunzhi {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();  //储存每层节点个数
        List<Double> sum = new ArrayList<>();  //储存每层的和
        dfs(root, 0, count, sum);  //递归遍历
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < sum.size(); i++) {
            res.add(sum.get(i) / count.get(i));
        }
        return res;
    }

    public void dfs(TreeNode root, int level, List<Integer> count, List<Double> sum) {
        if(root == null) return;

        if(level < sum.size()) {  //当已保存的数据中有该层数时，直接在相应层数的数据上进行更新
            count.set(level, count.get(level) + 1);
            sum.set(level, sum.get(level) + root.val);
        }
        else {  //若是一层新的节点，该层节点数起始为1，和起始为当前节点值
            count.add(1);
            sum.add(1.0 * root.val);
        }

        //递归左右子树
        dfs(root.left, level + 1, count, sum);
        dfs(root.right, level + 1, count, sum);
    }
}
