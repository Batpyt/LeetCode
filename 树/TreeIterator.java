package 树;

import java.util.Stack;
/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。
 */

/*
维护一个新的栈，里面记录了从小到大的左子节点
 */
public class TreeIterator {
    //新的栈
    Stack<TreeNode> s;
    public TreeIterator(TreeNode root) {
        this.s = new Stack<TreeNode>();

        //开始记录左子节点
        this._leftinorder(root);
    }

    //记录左子节点的帮助方法
    public void _leftinorder(TreeNode root) {
        //遍历左子节点，将节点依次入栈
        while(root != null) {
            this.s.push(root);
            root = root.left;
        }
    }


    /** @return the next smallest number */
    public int next() {
        //从栈顶开始弹出
        TreeNode topnode = this.s.pop();
        //若当前节点有右子节点，以右子节点为根记录其左子节点
        if(topnode.right != null) {
            this._leftinorder(topnode.right);
        }

        return topnode.val;
    }

    /** @return whether we have a next smallest number */
    //当维护的栈的大小为0时，树遍历结束
    public boolean hasNext() {
        return this.s.size() > 0;

    }
}
