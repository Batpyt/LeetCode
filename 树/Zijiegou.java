package 树;

/*
 * 
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。


 */
/*
 * 递归方法。从跟节点往下找，如果一样，一直往下找直到找到叶子节点（到底），若不一样直接返回false。
 */
public class Zijiegou {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
    	if(A == null || B == null) {  //空树不是任何树的子结构
    		return false;
    	}
    	if(A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right)) {  //当找到第一对相等的节点后，开启递归
    		return true;
    	}
    	
        
    	return isSubStructure(A.left, B) || isSubStructure(A.right, B);  //一直往下找直到找到第一对相等的节点。
    }
    
    public static boolean recur(TreeNode a, TreeNode b) {
    	if(b == null) {  //若b为null，说明找到尾部了，说明前面的节点都相等，返回true
    		return true;
    	}
    	if(a == null) {  //若a找到尾部了却还没返回true，说明不想等，返回false
    		return false;
    	}
    	if(a.val == b.val) {  //若a和b的节点相等，继续往左子树和右子树递归
    		return recur(a.left, b.left) && recur(a.right, b.right);
    	}
    	else {
    		return false;
    	}
    }
    	
}
