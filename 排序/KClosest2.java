package 排序;

import java.util.Arrays;
/*
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 用快排的思想
 */

public class KClosest2 {
    public static void main(String[] args) {
        int[][] p = {{3, 3}, {5, -1}, {-2, 4}};
        KClosest2 k = new KClosest2();
        int[][] res = k.kClosest(p, 2);
        for(int[] i : res) {
            for(int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }

    }

    public int[][] kClosest(int[][] points, int K) {
        quikSort(points, 0, points.length - 1);
        return Arrays.copyOf(points, K);

    }

    public static void quikSort(int[][] points, int low, int high) {
        if(low < high) {
            int index = getIndex(points, low, high);

            quikSort(points, low, index - 1);
            quikSort(points, index + 1, high);
        }
    }

    /**
     *快排，排序比的大小改为距离原点的距离
     * @param points
     * @param low
     * @param high
     * @return
     */
    public static int getIndex(int[][] points, int low, int high) {
        int temp[] = points[low];
        while(low < high) {
            while(low < high && dis(points[high]) >= dis(temp)) {
                high--;
            }
            points[low] = points[high];
            while(low < high && dis(points[low]) <= dis(temp)) {
                low++;
            }
            points[high] = points[low];
        }
        points[low] = temp;
        return low;
    }

    public static double dis(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
