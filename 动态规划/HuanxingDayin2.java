package 动态规划;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class HuanxingDayin2 {
	public static void main(String[] args) {
		int[][] res = generateMatrix(3);
		for(int[] r : res) {
			for(int i : r) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

	/*
	1 2 3
	8 9 4
	7 6 5
	 */
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int c = 1;
		int left = 0, right = n - 1, top = 0, bottom = n - 1;

		/*
		与环形打印思路相似，设置上下左右四个参数
		 */
		while(c <= n * n) {
			for(int i = left; i <= right; i++) {
				res[top][i] = c;
				c++;
			}
			top++;
			if(c > n * n) break;
			for(int i = top; i <= bottom; i++) {
				res[i][right] = c;
				c++;
			}
			right--;
			if(c > n * n) break;
			for(int i = right; i >= left; i--) {
				res[bottom][i] = c;
				c++;
			}
			bottom--;
			if(c > n * n) break;
			for(int i = bottom; i >= top; i--) {
				res[i][left] = c;
				c++;
			}
			left++;
			if(c > n * n) break;
		}
		return res;
	}
}
