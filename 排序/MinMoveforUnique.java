package 排序;

import java.util.Arrays;
/*
给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

返回使 A 中的每个值都是唯一的最少操作次数。

示例 1:

输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinMoveforUnique {
    public static void main(String[] args) {
        int[] a = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(a));
    }

    /*
    先给数组排序，只要后面的数是前面的数+1即可
     */
    public static int minIncrementForUnique(int[] A) {
        if(A.length == 1) return 0;
        Arrays.sort(A);
        int res = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] >= A[i + 1]) {
                //res的计算为res+将后一个树加到比当前数大所需次数
                res = A[i] - A[i + 1] + 1 + res;
                A[i + 1] = A[i] + 1;
            }
        }
        return res;
    }
}
