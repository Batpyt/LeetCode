package 树;

import 链表.ListNode;

import java.util.*;

public class PathSum2 {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if(root == null) return;

        path.addLast(root.val);
        sum = sum - root.val;
        if(root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<Integer>(path));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
        path.removeLast();
    }
}
