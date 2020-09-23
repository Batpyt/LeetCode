package DFS;
import java.util.*;
/*
给定一组不含重复元素    的整数数组nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
 */

public class Ziji {
    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        Ziji sub = new Ziji();

        List<List<Integer>> res = sub.subsets(nums);
        //System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int begin, int[] nums) {
        if(begin == nums.length) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        path.add(nums[begin]);
        dfs(begin + 1, nums);
        path.remove(path.size() - 1);
        dfs(begin + 1, nums);
    }
}
