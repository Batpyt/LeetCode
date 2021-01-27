package 动态规划;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

1 2 3
4 5 6
7 8 9

 */
public class Huixingdayin {
	public static void main(String[] args) {
		int[][] num = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		
		int[] res = spiralOrder(num);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

		int[] r = rotatePrint(num);
		for(int i : r) {
			System.out.print(i +" ");
		}
		
	}
	/*
	 * 从左到右，从上到下，从右到左，从下到上，循环打印。
	 * 四个边界值，左边l，右边r，上边t，下边b。
	 * 从左到右读取时，纵坐标是t，横坐标由l到r，读取完后t-1，代表本行读取完毕。
	 * 从上到下，纵坐标由t到b，横坐标r，读取完r-1，代表本列读取完毕。
	 * 从右到左，纵坐标b，横坐标r到l，完毕后b-1.
	 * 从下到上，纵坐标b到t，横坐标l，完毕后l-1.
	 * 每次读取完一列/行都检测是否读取完全部数据，若读取完则break。
	 */
	public static int[] rotatePrint(int[][] matrix) {
		int res[] = new int[matrix.length * matrix[0].length];
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int count = 0;

		while (true) {
			for(int i = left; i <= right; i++) {
				res[count] = matrix[top][i];
				count++;
			}
			if(count >= res.length) break;
			top++;

			for(int i = top; i <= bottom; i++) {
				res[count] = matrix[i][right];
				count++;
			}
			if(count >= res.length) break;
			right--;

			for(int i = right; i >= left; i--) {
				res[count] = matrix[bottom][i];
				count++;
			}
			if(count >= res.length) break;
			bottom--;

			for(int i = bottom; i >= top; i--) {
				res[count] = matrix[i][left];
				count++;
			}
			if(count >= res.length) break;
			left++;
		}
		return res;
	}

	
    public static int[] spiralOrder(int[][] matrix) {
    	int[] res = new int[matrix[0].length * matrix.length];
    	int l = 0;
    	int r = matrix[0].length - 1;
    	int t = 0;
    	int b = matrix.length - 1;
    	int count = 0;
    	
    	while(true) {
    		for(int i = l; i <= r; i++) {
    			res[count] = matrix[t][i];
    			//System.out.println(i);
    			count++;
    		}
    		if(count >= res.length) {
    			break;
    		}
    		t++;
    		
    		for(int i = t; i <= b; i++) {
    			res[count] = matrix[i][r];
    			//System.out.println(i);
    			count++;
    		}
    		if(count >= res.length) {
    			break;
    		}
    		r--;
    		
    		for(int i = r; i >= l; i--) {
    			res[count] = matrix[b][i];
    			//System.out.println(i);
    			count++;
    		}
    		if(count >= res.length) {
    			break;
    		}
    		b--;
    		
    		for(int i = b; i >= t; i--) {
    			res[count] = matrix[i][l];
    			count++;
    		}
    		if(count >= res.length) {
    			break;
    		}
    		l++;
    	}
    	
    	return res;
    }

}
