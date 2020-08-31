package 排序;

import java.util.*;
/*
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

 */
/*
 * 判断条件：只要最大牌与最小牌的差小于5，则为顺子。
 */

public class Shunzi {
	public static void main(String[] args) {
		int[] nums = {0,0,1,2,5};
		int[] nums2 = {0,0,2,2,5};
		int[] nums3 = {0,1,3,4,5};
		System.out.println(isStraight(nums2));
	}
	
	public static boolean isStraight(int[] nums) {
		Set<Integer> repeat = new HashSet<>();
		int max = 0;
		int min = 99;
		
		for(int num : nums) {
			if(num != 0) {
				max = Math.max(max, num);  //最大牌
				min = Math.min(min, num);  //最小牌
				if(repeat.contains(num)) return false;  //若监测到对子直接返回false
				repeat.add(num);
			}
		}
		
		return max - min < 5;
		
	}

}
