package 不知名类型;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

 如果有多个答案，你可以返回其中任何一个。保证答案存在。



 示例 1：

 输入：A = [1,1], B = [2,2]
 输出：[1,2]
 示例 2：

 输入：A = [1,2], B = [2,3]
 输出：[1,2]
 */

public class CandySwap {
	public static void main(String[] args) {
		int[] a = {1,2,5};
		int[] b = {2,4};
		int[] res = fairCandySwap(a, b);
		System.out.println(res[0] + " " + res[1]);
	}

	/*
	公式推导：
	x = y + (suma - sumb) / 2
	 */
	public static int[] fairCandySwap(int[] A, int[] B) {
		Set<Integer> set = new HashSet<>();
		for(int i : A) {
			set.add(i);
		}
		int suma = Arrays.stream(A).sum();
		int sumb = Arrays.stream(B).sum();
		int gap = (suma - sumb) / 2;
		System.out.println(gap);
		int[] res = new int[2];
		for(int i : B) {
			if(set.contains(i + gap)) {
				res[0] = i + gap;
				res[1] = i;
				break;
			}
		}
		return res;
	}
}
