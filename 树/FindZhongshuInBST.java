package 树;

import java.util.ArrayList;

public class FindZhongshuInBST {
	//上一个值，目前的出现次数，最大的出现次数
	int prenum = 0, curtime = 0, maxtime = 0;
	ArrayList<Integer> list = new ArrayList<>();
	public int[] findMode(TreeNode root) {
		Inorder(root);
		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	/*
	中序遍历
	 */
	public void Inorder(TreeNode root) {
		if(root == null) return;
		Inorder(root.left);
		//若上一个值=当前值，当前次数++
		if(prenum == root.val) {
			curtime++;
		}
		//若不一样，更新上一个的值和当前次数
		else {
			prenum = root.val;
			curtime = 1;
		}

		//若当前和以前最大次数相等，将值加入列表
		if(curtime == maxtime) {
			list.add(root.val);
		}
		//若大于以前最大次数，更新列表
		else if (curtime > maxtime) {
			list.clear();
			list.add(root.val);
			maxtime = curtime;
		}
		Inorder(root.right);
	}
}
