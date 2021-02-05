package 双指针和滑动窗口;

/**
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 *
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetEqualSubstringsWithBudget {
	public static void main(String[] args) {
		String s = "abcd", t = "cdef";
		System.out.println(equalSubstring(s, t, 3));
	}

	/*
	先在diff数组中记录每个字符对应的差的绝对值
	后双指针
	 */
	public static int equalSubstring(String s, String t, int maxCost) {
		int[] diff = new int[s.length()];
		//先在diff数组中记录每个字符对应的差的绝对值
		for(int i = 0; i < s.length(); i++) {
//			if(s.charAt(i) != t.charAt(i)) diff[i] = 1;
//			else diff[i] = 0;
			diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
			System.out.println(diff[i]);
		}

		int left = 0, right = 0, max = 0, sum = 0;
		//双指针，每次sum加上当前右指针对应的字符差值
		while(right < s.length()) {
			sum += diff[right];
			//若差值和大于最大开销，减去左指针的差值，并右移左指针
			while(sum > maxCost) {
				sum -= diff[left];
				left++;
			}
			//记录最大长度
			max = Math.max(right - left + 1, max);
			//右指针右移
			right++;
		}
		return max;
	}
}
