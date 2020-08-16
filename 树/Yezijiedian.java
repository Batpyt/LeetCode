package 树;

public class Yezijiedian {
	class Node{
		Node left;
		Node right;
		int val;
	}
	
	boolean isLeafAP(Node root) {
		int[] num = Shu(root);
		if(num.length < 3) {
			return true;
		}
		
		int cha = num[1] - num[0];
		
		for(int i = 2; i < num.length; i++) {
			if(num[i] - num[i - 1] != cha) {
				return false;
			}
		}
		
		
		
		return true;
	}
	
	public static int[] Shu(Node root) {
		StringBuilder sb = new StringBuilder();
		Node temp = root;
		
		if(temp.left == null && temp.right == null) {
			sb.append(" "+temp.val);
		}
		Shu(temp.left);
		Shu(temp.right);
		
		String[] str = sb.toString().split(" ");
		int[] res = new int[str.length];
		for(int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(str[i]);
		}
		
		
		return res;
	}

}
