package 双指针和滑动窗口;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 *
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LongestRepeating {
	public static void main(String[] args) {
		String s = "AABABBA";
		System.out.println(characterReplacement(s, 1));
	}

	/*
	滑动窗口，扩张时右指针右移，滑动时左右指针同时右移
	同时有个max：窗口相同字母出现的最大值
	每次根据新遍历到的窗口最右边的字符更新max
	当right-left+1 > max+k时，窗口滑动
	 */
	public static int characterReplacement(String s, int k) {
		//创建数组用来记录每个字符出现的次数
		int[] map = new int[26];
		int right = 0;
		int left = 0;
		int max = 0;
		char[] cs = s.toCharArray();
		for(right = 0; right < cs.length; right++) {
			//更新字符出现次数
			int index = cs[right] - 'A';
			map[index]++;

			//更新窗口内字符最大出现次数，如果新来的字符不同的话该值不会变，
			//相同的话下面的if不会走，直接扩张
			max = Math.max(map[index], max);

			//若max没变的话会引发窗口滑动
			if(right - left + 1 > max + k) {
				map[cs[left] - 'A']--;
				left++;
			}
		}
		return right - left;
	}

}
