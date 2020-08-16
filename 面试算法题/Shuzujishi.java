package 面试算法题;

public class Shuzujishi {
	public static void main(String[] args) {
		final int size = 20000;
		int[][] matrix1 = new int[size][size];
		int[][] matrix2 = new int[size][size];
		
		
		long t0 = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix1[i][j] = 9;
			}
		}
		
		long t1 = System.currentTimeMillis();
		for(int j = 0; j < size; j++) {
			for(int i = 0; i < size; i++) {
				matrix1[i][j] = 9;
			}
		}
		long t2 = System.currentTimeMillis();
		
		System.out.println(t1 - t0);
		System.out.println(t2 - t1);
		
	}

}
