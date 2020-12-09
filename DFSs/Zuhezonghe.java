package DFSs;
import java.util.*;

/*
给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的每个数字在每个组合中只能使用一次。
 */
/*
使用回溯法和剪枝。
先排序，再递归，每次用target减去遍历到的元素
小剪枝：当遍历到与上一个元素相同的元素时，跳过这次循环。
大剪枝：当遍历到的元素的和已经大于target。
 */

public class Zuhezonghe {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0) return res;

        Arrays.sort(candidates);  //排序元素
        Deque<Integer> path = new ArrayDeque<>(candidates.length);  //path用来储存每次遍历的元素
        dfs(candidates, 0, target, path, res);
        return res;
    }

    public void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target == 0) {  //当前结果符合条件
            res.add(new ArrayList<>(path));  //将元素存到res中
            return;
        }

        for(int i = begin; i < candidates.length; i++) {  //
            if(target - candidates[i] < 0) break;  //大剪枝

            if(i > begin && candidates[i] == candidates[i - 1]) continue;  //小剪枝

            path.addLast(candidates[i]);

            dfs(candidates, i + 1, target - candidates[i], path, res);

            path.removeLast();

        }
    }
}
