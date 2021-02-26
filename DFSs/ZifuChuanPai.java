package DFSs;

import java.util.*;

public class ZifuChuanPai {
	public static void main(String[] args) {

	}

	List<String> list = new ArrayList<>();
	char[] c;
	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return list.toArray(new String[list.size()]);
	}

	public void dfs(int x) {
		if(x >= c.length) {
			list.add(String.valueOf(c));
			return;
		}

		HashSet<Character> set = new HashSet<>();
		for(int i = x; i < c.length; i++) {
			if(set.contains(c[i])) {
				continue;
			}
			set.add(c[i]);
			swap(i, x);
			dfs(x + 1);
			swap(x, i);
		}
	}

	public void swap(int x, int i) {
		char temp = c[x];
		c[x] = c[i];
		c[i] = temp;
	}
}
