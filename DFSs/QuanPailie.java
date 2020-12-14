package DFSs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class QuanPailie {
    public static void main(String[] args) {
        QuanPailie q = new QuanPailie();
        int[] nums = {1,3,2};
        System.out.println(q.permuteUnique(nums));
        System.out.println(q.permute(nums));
    }

    //set自带去重
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    //dfs
    private void dfs(int[] nums, int cur) {
        if(cur == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i : nums) {
                list.add(i);
            }
            set.add(list);
        }
        else {
            for(int i = cur; i < nums.length; i++) {
                swap(nums, cur, i);
                System.out.println(cur+" "+i+" ");
                dfs(nums, cur + 1);
                swap(nums, cur, i);
            }
        }
    }

    private  void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //结果列表
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs1(nums, 0);
        return res;
    }

    private void dfs1(int[] nums, int cur) {
        //当所有数都填完了，加入结果列表中
        if(cur == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i : nums) {
                list.add(i);
            }
            res.add(list);
        }
        else {
            //将数循环插入
            for(int i = cur; i < nums.length; i++) {
                //动态维护数组
                swap(nums, cur, i);
                //填入下个数
                dfs1(nums, cur+1);
                //撤销操作
                swap(nums, cur, i);
            }
        }
    }
}

