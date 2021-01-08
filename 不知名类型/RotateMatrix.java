package 不知名类型;

public class RotateMatrix {
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(m);
		for(int[] i : m) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

	/*
	1 2 3
	4 5 6
	7 8 9

	7 8 9
	4 5 6
	1 2 3

	7 4 1
	8 5 2
	9 6 3
	 */
	public static void rotate(int[][] matrix) {
		//上下翻转
		for(int i = 0; i < matrix.length / 2; i++) {
			for(int j = 0; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - i][j];
				matrix[matrix.length - 1 - i][j] = temp;
				//System.out.println(matrix[i][j]+" "+ matrix[matrix.length - 1 - i][j]);
			}
		}

		//右上左下翻转
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}


}
