package 动态规划;

import java.util.Arrays;
import java.util.Comparator;
/*
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

说明:
不允许旋转信封。

示例:

输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/russian-doll-envelopes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
转为最大子序列问题
先根据第一个元素升序排列，再计算第二个元素的最大子序列问题。
 */

public class Envelopes {
    public static void main(String[] args) {
        int[][] en = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(en));
        System.out.println(Envelopes(en));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        //自定义排序，根据第一个元素升序排列数组
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                else {
                    return o1[0] -o2[0];
                }
            }
        });

        //最大子序列问题
        int[] n = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
            n[i] = envelopes[i][1];
        }

        int[] dp = new int[n.length];
        for(int num : n) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(dp[m] < num) i = m + 1;
                else j = m;
            }
            dp[i] = num;
            if(res == j) res++;
        }

        return res;
    }

    public static int Envelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }

        });

        int[] nums = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        int res = Lis(nums);
        return res;
    }

    public static int Lis(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
