package 不知名类型;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SummaryRanges {
    public static void main(String[] args) {
        //int[] nums = {0,1,2,4,5,7};
        int[] n = {0,2,3,4,6,8,9};
        //System.out.println(summaryRanges(nums));
        System.out.println(summaryRanges(n));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if(nums.length <= 0) return res;
        //两个变量记录起始点和上一个点
        int pre = nums[0];
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //若连续
            if (nums[i] - 1 == pre) {
                pre = nums[i];
            }
            //若不连续，将本范围记录
            else {
                String s = "";
                //分情况：范围只有一个数
                if(pre == start) {
                    s = String.valueOf(start);
                }
                //多个数
                else {
                    s = start + "->" + pre;
                }
                start = nums[i];
                pre = nums[i];

                res.add(s);
            }
        }
        //最后一个范围同理分情况
        if(start == nums[nums.length - 1]) {
            res.add(String.valueOf(nums[nums.length - 1]));
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
