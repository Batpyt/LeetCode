package DFSs;

import java.util.Scanner;
/*
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：
输入：m = 2, n = 3, k = 1
输出：3

示例 2：
输入：m = 3, n = 1, k = 0
输出：1
 */

public class Zougezi {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			//Integer i = m;
			//System.out.println(i.toString().split("")[1]);
			System.out.println(movingCount(m, n, k));
		}
	}

	public static int movingCount(int m, int n, int k) {
		int count = 0;
		boolean[][] visited = new boolean[m][n];
		return dfs(0,0,m,n,k,visited);
	}

	public static int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
		if(i >= m || j >= n || visited[i][j] || sum(i,j) > k) {
			return 0;
		}
		visited[i][j] = true;

		int res = dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
		return res + 1;
	}

	public static int sum(int i, int j) {
		int sum = 0;
		Integer I = i;
		Integer J = j;
		String[] si = I.toString().split("");
		String[] sj = J.toString().split("");
		for(String s : si) {
			sum += Integer.parseInt(s);
		}
		for(String s : sj) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
	
//	/*
//	 * DFS方法，深度优先遍历。从(0,0)开始往下方和右方遍历。若i，j超过m，n，当前点已遍历过，或该点位数相加大于k，则返回0。
//	 */
//	public static int movingCount(int m,int n ,int k ) {
//		int count = 0;
//		boolean[][] b= new boolean[m][n]; //用来记录是否遍历过
//
//		//System.out.println(b[0][0]);
//		return dfs(0, 0, m, n, k, b);
//	}
//
//	public static int dfs(int i, int j, int m, int n, int k, boolean[][] b) {
//		if(i >= m || j >= n || b[i][j] || Sum(i, j) > k) {
//			return 0;
//		}
//		//System.out.println(i+" "+j);
//		b[i][j] = true; //标记为已遍历过。
//		int res = dfs(i + 1, j, m, n, k, b) + dfs(i, j + 1, m, n, k, b);
//
//		return res + 1;
//	}
//
//	public static int Sum(int i, int j) {
//		Integer I = i;
//		Integer J = j;
//		int sum = 0;
//		String[] si = I.toString().split("");
//		String[] sj = J.toString().split("");
//		for(int a = 0; a < si.length; a++) {
//			sum = sum + Integer.parseInt(si[a]);
//		}
//		for(int b = 0; b < sj.length; b++) {
//			sum = sum + Integer.parseInt(sj[b]);
//		}
//		//System.out.println(sum);
//
//		return sum;
//	}

}
