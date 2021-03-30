package 树;

import java.util.*;
/*
二叉树构造器
 */

public class BSTIterator {
    private int index = 0;
    private List<Integer> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
