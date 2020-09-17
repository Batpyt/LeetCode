package 树;

import java.util.HashMap;

public class Gouzaierchashu {
    private HashMap<Integer, Integer> indexMap;

    /*
    四个参数，当前树在前序遍历数组中的首尾下标，
    当前树在中序遍历数组中的首尾下标。
     */
    public TreeNode buildTree(int[] preorder, int preleft, int preright, int inleft, int inright) {
        if(preleft > preright) {
            return null;
        }

        int rootval = preorder[preleft];  //当前树的根节点为前序遍历的第一个值，获取值
        TreeNode root = new TreeNode(rootval);  //根据HashMap获取根的节点
        int pindex = indexMap.get(rootval);  //获取根节点在中序遍历数组中的下标

        //递归遍历并拼接树，递归分为左子树和右子树
        //pre：   根        ｜         左子树                         ｜                  右子树              ｜
        //    preleft       preleft+1        pindex-inleft+preleft  pindex-inleft+preleft+1           preright
        //其中（pindex-inleft+preleft）是根据左子树数量相同算出来的。

        //in:｜         左子树                        |      根       ｜                  右子树              ｜
        //   inleft                         pindex-1  pindex          pindex+1                           inright
        root.left = buildTree(preorder, preleft + 1, pindex - inleft + preleft, inleft, pindex - 1);
        root.right = buildTree(preorder, pindex - inleft + preleft + 1, preright, pindex + 1, inright);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);  //key是中序遍历的数值，value是对应的下标
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


}
