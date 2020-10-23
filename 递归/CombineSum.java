package 递归;
import 链表.ListNode;

import java.util.*;

public class CombineSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();//用来储存每个结果的list
        dfs(candidates, 0, target, path, res);
        return res;

    }

    /*
    回溯法
    一条道走到黑，如果某一条不行，往回退一步，再试另一条
     */
    private static void dfs(int[] candidates, int begin, int target, Deque<Integer> path
            , List<List<Integer>> res) {
        if(target < 0) return;  //这条道路的结果已经大于sum，不记录并返回

        if(target == 0) {//当前道路的结果==sum
            res.add(new ArrayList<>(path));//将该结果记录
            return;
        }

        for(int i = begin; i < candidates.length; i++) {//从begin开始
            path.addLast(candidates[i]);//将当前候选加入用来储存的list
            dfs(candidates, i, target - candidates[i], path, res);//下一次继续从begin开始

            path.removeLast();//还原
        }
    }

}
