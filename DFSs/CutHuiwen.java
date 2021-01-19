package DFSs;

import java.util.*;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CutHuiwen {
	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> cur = new ArrayList<>();
		dfs(s, res, cur, 0);
		return res;
	}

	/**
	 *
	 * @param s 原字符串
	 * @param res 最终结果
	 * @param cur 当前结果
	 * @param start 遍历字符串位置
	 */
	public static void dfs(String s, List<List<String>> res, List<String> cur, int start) {
		if(start == s.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}

		for(int i = start; i < s.length(); i++) {
			String s1 = s.substring(start, i + 1);
			if(!isHuiwen(s1)) continue;
			cur.add(s1);
			dfs(s,res, cur, i+1);
			cur.remove(cur.size()-1);
		}
	}

	public static boolean isHuiwen(String s) {
		int l = 0, r = s.length() - 1;
		if(s == null || s.length() <= 1) {
			return true;
		}
		while (l < r) {
			if(s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}
