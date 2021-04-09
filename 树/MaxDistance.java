package 树;

/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A 到B的距离。
 */

/*
二叉树中最大距离只可能来自以下三种情况:
1.h的左子树上的最大距离
2.h的右子树上的最大距离
3.h的左子树上离h.left最远的距离+1+h的右子树离h.rigth最远的距离。

根据上述所说我们使用后序遍历。详细代码如下:因为这里需要知道两个值，左最大和左子树中离h.left最远距离。但是递归中需要返回两个值，我们一个值使用递归返回，一个值使用全局变量保存。代码如下:
————————————————
版权声明：本文为CSDN博主「li563868273」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/li563868273/article/details/51285655
 */
public class MaxDistance {
	public int maxDistance(TreeNode head){
		int[] record=new int[1];
		return posOrder(head,record);
	}

	private int posOrder(TreeNode head, int[] record) {
		if (head==null){
			record[0]=0;
			return 0;
		}
		int lMax=posOrder(head.left,record);//记录左子树最大
		int maxfromLeft=record[0];//记录左子树上离h.left最远距离
		int rMax=posOrder(head.right,record);//记录右子树最大
		int maxfromRight=record[0];//记录右子树上离h.right最远距离
		int curNodeMax=maxfromLeft+maxfromRight+1;
		record[0]=Math.max(maxfromLeft,maxfromRight)+1;//寻找到该节点最远加1
		return Math.max(Math.max(lMax,rMax),curNodeMax);
	}
}
