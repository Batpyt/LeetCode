package DFS;
import java.util.*;
/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */


public class Zuhezhengshu {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k < 0 || n < k) return res;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    /*
    根据搜索起点画出数组。
    新建path来记录每一个数组的路径。
    递归从第一个开始，每次path的大小等于k，则将path添加到res中。

     */
    public static void dfs(int n, int k, int i, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j <= n; j++) {
            path.addLast(j);  //向path中添加数字
            System.out.println(j+ "递归之前-> " + path);
            dfs(n, k, j + 1, path, res);  //下一轮搜索的起点+1
            //System.out.println("递归之后-> " + path);
            path.removeLast();  //每经历完一次搜索，逆向操作。
            System.out.println(j+ "递归之后-> " + path);
        }

    }
}
