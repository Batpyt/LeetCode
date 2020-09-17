package 树;

import java.util.HashMap;
/*
根据一棵树的中序遍历与后序遍历构造二叉树。
 */
/*
先新建hashmap储存节点值和节点在中序遍历中位置的下标。
后续遍历数组的最后一位是跟节点，可以通过该节点值定位到该值在中序遍历中的下标，pindex。
通过pindex可计算出左边的子树的长度：pindex - 1 - inleft，
然后代回postorder中，计算出左子树的有边界，右子树的左边界。
post:｜        左子树                        ｜             右子树                       ｜    根     ｜
      postleft     posrleft+pindex-1-inleft   posrleft+pindex-inleft         postright-1    postright

in:  ｜         左子树                        |      根       ｜                  右子树              ｜
     inleft                         pindex-1     pindex      pindex+1                           inright
 */

public class Gouzaoerchashu2 {
    private HashMap<Integer, Integer> indexmap;

    public TreeNode buildTree(int[] postorder, int postleft, int postright, int inleft, int inright) {
        if(postleft > postright) {
            return null;
        }

        int rootval = postorder[postright];  //跟节点的值
        TreeNode root = new TreeNode(rootval);  //将该节点建树
        int pindex = indexmap.get(rootval);  //找到跟节点在前序遍历中的位置。

        root.left = buildTree(postorder, postleft, postleft + pindex - 1 - inleft, inleft, pindex - 1);
        root.right = buildTree(postorder, postleft + pindex - inleft, postright - 1, pindex + 1, inright);

        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            indexmap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
}
