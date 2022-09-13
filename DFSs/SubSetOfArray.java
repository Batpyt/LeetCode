package DFSs;

import java.util.*;

public class SubSetOfArray {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, res, path);
        return res;
    }

    public void dfs(int[] nums, int begin, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for(int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }


}
