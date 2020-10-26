package 树;

/*
如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
示例1:
 输入：t1 = [1, 2, 3], t2 = [2]
 输出：true

示例2:
 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 输出：false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-subtree-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
本质为双层dfs
 */
public class IsSubTree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //若都是空的，返回true，若t1是空的而t2不是，返回false
        if(t1 == null) return t2 == null;
        //先判断当前节点是否符合，若不符合再想左右子树进行遍历
        return checkSubTreefromRoot(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean checkSubTreefromRoot(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2 == null;//当都为空，则遍历到了叶子节点，返回true
        if(t2 == null) return t1 == null;//若有一个不为空，则不正确
        if(t1.val != t2.val) return false;//若节点值不一样，返回false

        //当前节点符合，继续往左右两边节点遍历
        return checkSubTreefromRoot(t1.left, t2.left) || checkSubTreefromRoot(t1.right, t2.right);
    }
}
