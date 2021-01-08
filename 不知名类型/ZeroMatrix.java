package 不知名类型;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] m = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(m);
		for(int[] i : m) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {
		int length1 = matrix.length;
		int length2 = matrix[0].length;
		//建立二维数组，来记录数组中的0是本来的还是改为0的
		boolean[][] changedzero = new boolean[length1][length2];
		for(int i = 0; i < length1; i++) {
			for(int j = 0; j < length2; j++) {
				//只有当0是本来的才左操作
				if(matrix[i][j] == 0 && !changedzero[i][j]) {
					System.out.println(i+" "+j);
					for(int k = 0; k < length2; k++) {
						//只有当本来不是0，才更改新建的二维数组
						if(matrix[i][k] != 0) {
							changedzero[i][k] = true;
							//System.out.println(matrix[i][k]);
						}
						matrix[i][k] = 0;

					}

					for(int k = 0; k < length1; k++) {
						if(matrix[k][j] != 0) changedzero[k][j] = true;
						matrix[k][j] = 0;
					}
				}
			}
		}
//		for(boolean[] b : changedzero) {
//			for(boolean q : b) {
//				System.out.print(q+" ");
//			}
//			System.out.println();
//		}
	}
}
