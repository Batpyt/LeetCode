package 不知名类型;

public class TransposeMatrix {
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{4,5,6}};
		int[][] res = transpose(m);
		for(int[] i : res) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

	/*
	1 2 3
	4 5 6

	1 4
	2 5
	3 6
	 */
	public static int[][] transpose(int[][] matrix) {
		int[][] res = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				res[j][i] = matrix[i][j];
			}
		}
		return res;
	}
}
