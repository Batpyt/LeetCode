package 排序;
/*
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MountainArray {
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        int[] b = {1,2,3,3,4,5,4,3,1};
        int[] c = {1,3,2};
        System.out.println(validMountainArray(a));
        System.out.println(validMountainArray(b));
    }

    public static boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        int i = 1;
        while(true) {
            if(A[i] == A[i - 1]) return false;
            if(A[i] < A[i - 1]) break;
            i++;
            if(i >= A.length) return false;
        }

        if(i == 1) return false;

        while(true) {
            if(A[i] >= A[i - 1]) return false;
            i++;
            if(i == A.length) return true;
        }
    }

}
