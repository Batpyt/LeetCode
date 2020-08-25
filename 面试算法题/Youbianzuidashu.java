package 面试算法题;

/*
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 */
/*
 * 与辅助栈那题的区别是这个是输出右边最大，那个是输出右边第一个比自己大的。
 * 本体用倒叙遍历。最后一位固定为-1，那么倒数第二位固定为自己。
 * 之后一直都在赋值右边的最大值。
 */
public class Youbianzuidashu {
	public static void main(String[] args) {
		int[] num = {17,18,5,4,6,1};
		
		int[] res = You(num);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]+ ", ");
		}
	}
	
	public static int[] You(int[] num) {
		int[] res = new int[num.length];
		res[num.length - 1] = -1;
		for(int i = num.length - 2; i >= 0; i--) {
			res[i] = Math.max(res[i + 1], num[i + 1]);
		}
		return res;
	}

}
