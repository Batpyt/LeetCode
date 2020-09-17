package 动态规划;

import 树.TreeNode;
import 链表.ListNode;

import java.util.*;

/*
1、给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
2、给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树。
 */
public class Erchasousuoshu {
    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


    /*
    递归法。
    每个数轮流当作根节点，输出所有可能性。
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();

        return generateTrees(1, n);
    }


    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> alltrees = new LinkedList<TreeNode>();
        if(start > end) {
            alltrees.add(null);
            return alltrees;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> lefttrees = generateTrees(start, i - 1);  //所有可能的左子树
            List<TreeNode> righttrees = generateTrees(i + 1, end);  //所有可能的右子树

            for(TreeNode left : lefttrees) {  //左右子树拼接到根节点上
                for(TreeNode right : righttrees) {
                    TreeNode curtree = new TreeNode(i);
                    curtree.left = left;
                    curtree.right = right;
                    alltrees.add(curtree);
                }
            }
        }
        return alltrees;


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
