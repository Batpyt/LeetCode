package 双指针和滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayJiaoji {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int[] b = {2,4,6,7,8,9};
		int[ ]res = retainAll(a, b);
		for(int i : res) {
			System.out.print(i+" ");
		}

		char[] c1 = {'a','b','c','d','e','f','g'};
		char[] c2 = {'a','b','c','d','f','g'};
		System.out.println(findChar(c1, c2));
	}

	public static int[] retainAll(int[] array1, int[] array2) {
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();
		while(i < array1.length && j < array2.length) {
			if(array1[i] > array2[j]) {
				j++;
			}
			else if(array1[i] < array2[j]) {
				i++;
			}
			else {
				list.add(array1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[list.size()];
		for(int k = 0; k < res.length; k++) {
			res[k] = list.get(k);
		}
		return res;
	}

	public static char findChar(char[] chars1, char[] chars2) {
		int i = 0, j = 0;
		while(true) {
			if(chars1[i] != chars2[j]) {
				return chars1[i];
			}
			i++;
			j++;
		}
	}
}
