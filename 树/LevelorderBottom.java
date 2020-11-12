package 树;

import java.util.*;
/*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LevelorderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        //queue来储存每一层的节点，从根节点开始
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            //arraylist用来储存每一层节点的数值
            List<Integer> level = new ArrayList<>();
            //count来标志该层有几个节点
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                //将队列中的节点弹出
                TreeNode node = queue.poll();
                //并将结点的值接入arraylist
                level.add(node.val);

                //若左右子树还有，继续将子节点加入queue
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            //将该层的值加入res的前面
            res.addFirst(level);
        }
        return res;
    }

    //另一种写法，更简洁
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();

        if(root != null) queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> l = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.addFirst(l);
        }
        return res;
    }
}
