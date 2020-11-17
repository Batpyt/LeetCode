package 动态规划;

/**
 *
 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）

 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：



 0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 0 <= j < j + M - 1 < i < i + L - 1 < A.length.


 示例 1：

 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 输出：20
 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 */

public class MaxSumNoOverlap {
    public static void main(String[] args) {

    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        int res = A[L + M - 1];
        int Lmax = A[L - 1];
        int Mmax = A[M - 1];
        for (int i = L + M; i < A.length; i++) {
            // 分别以L在前M在后，M在前L在后两种方式，滑动窗口，每次移动一格。
            Lmax = Math.max(Lmax, A[i - M] - A[i - M - L]);
            Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
        }
        return res;
    }
}
