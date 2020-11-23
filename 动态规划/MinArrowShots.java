package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinArrowShots {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }

    /*
    先对二维数组进行排序
    然后遍历进行对比
     */
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        int res = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        //1,6 2,8 7,12 10,16
        //2,6 7,12 10,16

        //left，right代表的是能打爆当前所有气球的射击范围
        int left = points[0][0];
        int right = points[0][1];
        for(int i = 1; i < points.length; i++) {
            //13 45

            //若下一个气球的起始点大于范围右边，将下一个气球设为新的涉及范围，res++
            if(right < points[i][0]) {
                res++;
                left = points[i][0];
                right = points[i][1];
            }

            //13 24
            //13 34

            //若下一个气球的起始点小于等于范围右边，寻找新的范围：
            //范围左边是旧范围左边和气球左边更大的一个，范围右边是旧范围右边和气球左边更小的一个
            if(right >= points[i][0]) {
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
            }
        }
        return res;
    }
}
