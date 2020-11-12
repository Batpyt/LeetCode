package 动态规划;

/**
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 *
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 *
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 *
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxSubRingArray {
    public static void main(String[] args) {
        int[] a = {5,-3,5};
        maxSubRingArray m = new maxSubRingArray();
        System.out.println(m.maxSubarraySumCircular(a));
    }

    /*
    两种情况：1.子序列环在数组中间。2.环横跨了数组的首尾
    因此要记录数组中间的最小序列，若该序列小于0，则代表环时第二种情况。
     */
    public int maxSubarraySumCircular(int[] A) {
        if(A == null || A.length < 1) {
            return 0;
        }
        /**
         * curmax记录当前遍历的子序列的最大值
         * max记录已知的序列最大值
         * curmin记录当前便利的子序列的最小值
         * min记录已知的序列最小值
         */
        int curmax = A[0];
        int max = curmax;
        int curmin = curmax;
        int min = curmax;
        int sum = curmax;
        for(int i = 1; i < A.length; i++) {
            sum = sum + A[i];
            //只有curmax大于0时，curmax的值才会与当前值相加，不然只记录当前值
            curmax = curmax > 0 ? curmax + A[i] : A[i];
            //每次都比较是否是最大值
            max = curmax > max ? curmax : max;
            //只有curmin小于0时，curmin的值才会与当前值相加，不然只记录当前值
            curmin = curmin < 0 ? curmin + A[i] : A[i];
            //每次比较是否是最小值
            min = curmin < min ? curmin : min;
        }
        if(max < 0) return max;
        //只有当min<0时，sum-min会比max大，也就是横跨了数组的首尾
        return Math.max(sum - min, max);
    }
}
