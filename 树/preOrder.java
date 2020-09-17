package 树;
import java.util.*;

/*
前序遍历实现，根-左-右。
 */
public class preOrder {
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[3];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 3; i++) {
            node[i] = new TreeNode(i);
        }
        node[0].left = node[1];
        node[0].right = node[2];
        node[0].val = 2;
        node[1].val = 1;
        node[2].val = 3;
        //   2
        // 1   3
        preorder(node[0]);
        System.out.println();
        Preorder(node[0]);
    }

    //递归实现
    public static void preorder(TreeNode treeNode) {
        System.out.println(treeNode.val);  //先打印根
        TreeNode lefttree = treeNode.left;
        if(lefttree != null) {
            preorder(lefttree);  //遍历左子树
        }
        TreeNode righttree = treeNode.right;
        if(righttree != null) {
            preorder(righttree);  //遍历右子树
        }
    }

    //非递归实现
    public static void Preorder(TreeNode treeNode) {
        Deque<TreeNode> stack = new LinkedList<>();  //新建栈来储存节点
        while(treeNode != null || !stack.isEmpty()) {
            while(treeNode != null) {  //当前节点存在
                System.out.println(treeNode.val);  //输出该位置节点
                stack.push(treeNode);  //当前节点入栈
                treeNode = treeNode.left;  //遍历左子树。若该节点为叶子节点，其子节点为null，跳出该循环
            }
            if(!stack.isEmpty()) {  //栈中有节点
                treeNode = stack.pop();  //节点出栈
                treeNode = treeNode.right;  //遍历右子树。此时，treeNode有值了，上面的循环开启
            }
        }


    }
}
