package DFSs;
import java.util.*;
/*
给定一个无重复元素的数组candidate和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的数字可以无限制重复被选取。
 */
/*
回溯法，最大深度优先搜索。
每次target减去candidates里的值，并将减去的值存在一个栈path中。当target小于0时返回，当target等于0时将path加入到res中。
每次减去的值可以重复，但不能与上一层重复。例如2，2可以，3，2不可。
 */
public class Zuhezhongshu {
    public static void main(String[] args) {
        int[] can = {2,3,6,7};
        System.out.println(combinationSum(can, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();  //新建储存结果的list
        if(candidates.length == 0) return res;
        Deque<Integer> path = new ArrayDeque<>();  //储存每次遍历路径的栈
        dfs(candidates, 0, target, path, res);  //开始递归
        return res;

    }

    public static void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target < 0) return;  //当结果小于0时，该路径不正确，返回
        if(target == 0) res.add(new ArrayList<>(path));  //等于0时，将该路径添加到结果中

        //循环，每次循环的起点都往后移一位，因为不能遇上一层重复。
        for(int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], path, res);  //开始递归
            path.removeLast();
        }
    }
}
