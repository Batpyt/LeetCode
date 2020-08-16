package 树;
/*
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Jingxiang {
    public TreeNode mirrorTree(TreeNode root) {
    	TreeNode temp = root;
    	if(root == null) {
    		return null;
    	}
    	/*
    	 * 使用递归方法。先把右边的都移到左边，再把左边的移到右边
    	 */
    	TreeNode left = mirrorTree(root.right);
    	TreeNode right = mirrorTree(root.left);
    	
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }

}
