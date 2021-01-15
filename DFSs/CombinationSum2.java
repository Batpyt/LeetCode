package DFSs;

import java.util.*;

public class CombinationSum2 {
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		System.out.println(combinationSum2(candidates, 8));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(candidates.length <= 0) return res;

		Arrays.sort(candidates);
		Deque<Integer> cur = new ArrayDeque<>();
		dfs(candidates, target, 0, cur, res);
		return res;
	}

	public static void dfs(int[] candidates, int target, int begin, Deque<Integer> cur, List<List<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		if(target < 0) return;
		for(int i = begin; i < candidates.length; i++) {
			if(i > begin && candidates[i - 1] == candidates[i]) continue;
			cur.addLast(candidates[i]);
			dfs(candidates, target - candidates[i], i+1, cur, res);
			cur.removeLast();
		}
	}
}
