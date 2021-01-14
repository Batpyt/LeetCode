package DFSs;

import java.util.*;

public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println(combinationSum(candidates, 7));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(candidates.length == 0) return res;

		Deque<Integer> cur = new ArrayDeque<>();
		dfs(res, cur, candidates, target, 0);
		return res;
	}

	public static void dfs(List<List<Integer>> res, Deque<Integer> cur, int[] candidates, int target, int begin) {
		if(target == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}

		if(target < 0) {
			return;
		}

		for(int i = begin; i < candidates.length; i++) {
			cur.addLast(candidates[i]);
			dfs(res, cur, candidates, target - candidates[i], i);
			cur.removeLast();
		}
	}
}
