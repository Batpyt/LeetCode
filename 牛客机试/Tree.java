package 牛客机试;

import java.util.*;

/**
 * 根据前序遍历和中序遍历返回二叉树的层序遍历
 */

public class Tree {
    private HashMap<Character, Integer> indexMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        while(sc.hasNext()) {
            String str[] = sc.nextLine().split(" ");
            char[] pre = str[0].toCharArray();
            char[] in = str[1].toCharArray();
            TreeNode root = tree.buildTree(pre, in);
            char[] res = tree.levelOrder(root);
            String r = "";
            for(char c : res) {
                r += c;
            }
            System.out.println(r);
        }
    }

    public char[] levelOrder(TreeNode root) {
        if(root == null) {
            return new char[0];
        }

        ArrayList<Character> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);  //先储存根节点

        while(!que.isEmpty()) {
            TreeNode temp = que.poll();  //将第队列第一个节点从队列中弹出
            res.add(temp.val);  //记录该节点的数值
            if(temp.left != null) {  //将该节点的左子树压入队列
                que.add(temp.left);
            }
            if(temp.right != null) {  //右子树压入队列
                que.add(temp.right);
            }
        }

        char[] ans = new char[res.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public TreeNode buildTree(char[] preorder, int preleft, int preright, int inleft, int inright) {
        if(preleft > preright) {
            return null;
        }

        char rootval = preorder[preleft];  //当前树的根节点为前序遍历的第一个值，获取值
        TreeNode root = new TreeNode(rootval);  //根据HashMap获取根的节点
        int pindex = indexMap.get(rootval);  //获取根节点在中序遍历数组中的下标

        root.left = buildTree(preorder, preleft + 1, pindex - inleft + preleft, inleft, pindex - 1);
        root.right = buildTree(preorder, pindex - inleft + preleft + 1, preright, pindex + 1, inright);

        return root;
    }

    public TreeNode buildTree(char[] preorder, char[] inorder) {
        indexMap = new HashMap<Character, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

}
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(char val) {
        this.val = val;
    }
    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}