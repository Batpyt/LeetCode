package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class EraseOverlap {
    public static void main(String[] args) {
        int[][] in = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(in));
    }

    /*
    将数组的尾部升序排列，寻找最多能组成的不重叠区间的个数
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;

        //将尾部按照升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        //记录头尾
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            //13 24

            //如果上一个的尾部大于下一个的头部，说明重叠
            if(right > intervals[i][0]) {
                //right = intervals[i][1];
                left = intervals[i][0];
            }

            //13 45
            //13 34

            //与上一个不重叠，count++，更新头尾记录
            if(right <= intervals[i][0]) {
                count++;
                right = intervals[i][1];
                left = intervals[i][0];
            }
        }

        //返回总数组个数减去一共不重叠的个数
        return intervals.length - count;
    }
}
