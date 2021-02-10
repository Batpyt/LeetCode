package 双指针和滑动窗口;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationInString {
	public static void main(String[] args) {
		//String s1 = "ab", s2 = "eidbaooo";
		String s1= "ab", s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}

	/*
	滑动窗口
	先记录s1字符出现的次数
	再遍历s2
	 */
	public static boolean checkInclusion(String s1, String s2) {
		//两个数组记录字符出现次数
		int[] count1 = new int[26];
		int[] count2 = new int[26];
		for(char c : s1.toCharArray()) {
			count1[c-'a']++;
		}
		int left = 0, right = 0;
		char[] cs = s2.toCharArray();
		for(right = 0; right < cs.length; right++) {
			//每次记录右指针的字符
			count2[cs[right] - 'a']++;
			//若窗口大小大于s1长度，左指针右移
			if((right - left + 1) > s1.length()) {
				count2[cs[left] - 'a']--;
				left++;
			}
			//大小相同时，判断两字符串字符出现次数是否相同
			if((right - left + 1) == s1.length()) {
				if(Arrays.equals(count1, count2)) {
					return true;
				}
			}
		}
		return false;
	}
}
