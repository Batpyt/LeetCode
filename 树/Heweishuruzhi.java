package 树;
import java.util.*;
/*
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
/*
 * 使用递归，前序遍历，根-左子树-右子树。
 */
public class Heweishuruzhi {
	LinkedList<List<Integer>> res = new LinkedList<>();  //全局变量，最后的输出
	LinkedList<Integer> path = new LinkedList<>();  //全局变量，每一次得到的正确结果
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		recur(root, sum);
		return res;
    }
	
	/*
	 * 递归函数。每次都记录遍历到的节点的数值，并用最终需要得到的sum减这个值。
	 * 若遍历到叶子节点，且sum已经减到0，则代表这一路径是正确的，记录该路径。
	 * 若不正确，则将path中最后记录的删除。
	 */
	public void recur(TreeNode root, int sum) {
		if(root == null) {
			return;
		}
		path.add(root.val);  //将该节点记录到路径中
		sum = sum - root.val;  
		if(sum == 0 && root.left == null && root.right == null) {  //得到正确结果，记录
			res.add(new LinkedList(path));
		}
		recur(root.left, sum);
		recur(root.right, sum);
		path.removeLast();  //结果不正确，将最后记录的路径删除（回到上一个递归的记录）。
		
	}

}
