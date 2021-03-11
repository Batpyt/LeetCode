package DFSs;

import java.util.*;

public class CutHuiWen2 {
	public static void main(String[] args) {
		System.out.println(minCut("ababababababababababababcbabababababababababababa"));
	}


	public static int minCut(String s) {
		List<List<String>> res = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		List<String> cur = new ArrayList<>();
		dfs(res, cur, s, 0, min);
		for(List<String> list : res) {
			min = Math.min(min, list.size());
		}
		return min - 1;
	}

	public static void dfs(List<List<String>> res, List<String> cur, String s, int start, int min) {
		if(start >= s.length()) {
			min = Math.min(min, cur.size());
			res.add(new ArrayList<>(cur));
			return;
		}

		for(int i = start; i < s.length(); i++) {
			String temp = s.substring(start, i + 1);
			if(!isHuiWen(temp)) {
				continue;
			}
			cur.add(temp);
			dfs(res, cur, s, i + 1, min);
			cur.remove(cur.size() - 1);
		}
	}

	public static boolean isHuiWen(String s) {
		if(s == null || s.length() <= 1) {
			return true;
		}
		int left = 0, right = s.length() - 1;
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
