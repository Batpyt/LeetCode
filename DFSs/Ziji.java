package DFSs;
import java.util.*;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
