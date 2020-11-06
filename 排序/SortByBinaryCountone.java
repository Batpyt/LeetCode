package 排序;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SortByBinaryCountone {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBits(arr);
        for(int i : res) {
            System.out.print(i);
        }
    }

    /*
    Integer.bitCount api可以直接计算二进制后的1的个数，
    再构建一个新的sort中的comparator
     */
    public static int[] sortByBits(int[] arr) {
        Integer[] num = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            num[i] = arr[i];
        }
        Arrays.sort(num, (o1, o2) -> {
            int count1 = Integer.bitCount(o1);
            int count2 = Integer.bitCount(o2);
            //返回负数说说明o1<o2，如果o1的二进制1的个数小于o2，返回负数，反之相反
            if(count1 < count2) return -1;
            if(count1 == count2) return o1 - o2;
            else return 1;
        });
        for(int i = 0; i < arr.length; i++) {
            arr[i] = num[i];
        }
        return arr;
    }
}
