package 面试算法题;

import java.util.*;
/*
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
输入：target = 9
输出：[[2,3,4],[4,5]]
 */
/*
用滑动窗口方法。若窗口里的和小于目标，窗口右边界往右，
若和大于目标，窗口左边界往右。
 */

public class Heweisdexulie {
    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
        for(int i = 0; i < res.length; i++) {
            for(int num : res[i]){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1;  //左窗口
        int j = 1;  //右窗口
        int sum = 0;
        while(i <= target / 2) {  //在左边界大于目标值一半时跳出。
            if(sum < target) {  //右窗口右移
                sum = sum + j;
                j++;
            }
            if(sum > target) {  //左窗口右移
                sum = sum - i;
                i++;
            }
            if(sum == target){  //记录
                int[] arr = new int[j - i];
                for(int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum = sum - i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
