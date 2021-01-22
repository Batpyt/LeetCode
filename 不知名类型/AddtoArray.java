package 不知名类型;

import java.util.*;

public class AddtoArray {
	public static void main(String[] args) {
		int[] a = {1,2,0,0};
		System.out.println(addToArrayForm(a, 32 ));
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> res = new ArrayList<>();
		for(int i = A.length - 1; i >= 0; i--) {
			int temp = A[i] + K % 10;
			K = K /10;
			if(temp >= 10) {
				K++;
				temp = temp - 10;
			}
			res.add(temp);
		}
		for(int i = K; K > 0; K = K / 10) {
			res.add(K % 10);
		}
		Collections.reverse(res);
		return res;
	}
}
