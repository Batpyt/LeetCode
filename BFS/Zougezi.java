package BFS;

import java.util.*;
/*
 * 题干与DFS的走格子相同。
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
	
	/*
	 * 用BFS，广度优先遍历。利用一个队列，从(0,0)开始作为队列的第一个数组插入。数组为矩阵中的坐标。
	 * 开始遍历下方和右方，每次循环都poll出来队列中的一个数组。若数组的坐标超过了m，n，位数相加大于k，或者已遍历过，则跳过这次循环进入下一循环。
	 * 若符合条件，则count++，并继续往下往右遍历。
	 */
	
	public static int movingCount(int m,int n ,int k ) {
		int count = 0;
		boolean[][] b= new boolean[m][n]; //用来记录是否遍历过
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0});
		
		while(queue.size() > 0) {
			int[] x = queue.poll();
			if(x[0] >= m || x[1] >= n || Sum(x[0], x[1]) > k || b[x[0]][x[1]]) {
				continue;
			}
			b[x[0]][x[1]] = true;
			count++;
			
			queue.add(new int[] {x[0] + 1, x[1]});
			queue.add(new int[] {x[0], x[1] + 1});			
		}
		
		return count; 
	}
	
	public static int Sum(int i, int j) {
		Integer I = i;
		Integer J = j;
		int sum = 0;
		String[] si = I.toString().split("");
		String[] sj = J.toString().split("");
		for(int a = 0; a < si.length; a++) {
			sum = sum + Integer.parseInt(si[a]);
		}
		for(int b = 0; b < sj.length; b++) {
			sum = sum + Integer.parseInt(sj[b]);
		}
		//System.out.println(sum);
		
		return sum;
	}
	


}
