package 面试算法题;

import java.util.*;

public class Paobulujing {
	public static void main(String args[]) {
		
		String[] place = new String[5];
		place[0] = "Huilongguan";
		place[1] = "Chaoyang Park";
		place[2] = "National Stadium";
		place[3] = "Olympic Park";
		place[4] = "Tsinghua University";
		
		
		int[] ele = new int[5];
		ele[0] = 5;
		ele[1] = 25;
		ele[2] = 15;
		ele[3] = 20;
		ele[4] = 10;
				
		
		int[][] distance = new int[5][5];
		
		distance[0][1] = 10;
		distance[0][2] = 8;
		distance[0][3]= 15;
		distance[1][3] = 12;
		distance[2][4] = 10;
		distance[3][4] = 5;
		distance[3][0] = 17;
		distance[4][0] = 10;
		
		int sum = 0;
		boolean b = false;
		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(place[0]);
		
		while(!b) {
			if(sum > 0 && i == 0) {
				break;
			}
			int min = 999999;
			for(int a = 0; a < distance[0].length; a++) {
				if(distance[i][a] != 0 && distance[i][a] < min) {
					min = distance[i][a];
					j = a;
				}
			}
			sum = sum + min;
			sb.append(" -> ");
			sb.append(place[j]);
			i = j;
		}
		
		System.out.println(sum);
		System.out.println(sb.toString());
		
	}
	

}
