package 排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class KClosest {
    public static void main(String[] args) {
        int[][] p = {{3,3},{5,-1},{-2,4}};
        int[][] p1 = {{0,1},{1,0}};
        KClosest k = new KClosest();
        int[][] res = k.kClosest(p, 2);
        int[][] res1 = k.kClosest(p1,2);
        for(int[] i: res1) {
            for(int i1 : i) {
                System.out.print(i1+" ");
            }
            System.out.println();
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int l = points.length;

        //新建二维数组，储存点的序号和该点到原点的距离
        double[][] d = new double[l][2];
        //距离也单独记录在一个数组中
        double[] dis = new double[l];

        //计算点到原点的距离，并记入新建的二维数组和单独数组
        for(int i = 0; i < l; i++) {
            dis[i] = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            d[i][1] = dis[i];
            d[i][0] = i;
        }

        //排序距离数组
        Arrays.sort(dis);
        int[][] res = new int[K][2];

        //对照着排完序的距离数组对应的序号，序号对应的点记录
        for(int i = 0; i < K; i ++) {
            for(double[] j : d) {
                if(j[1] == dis[i]) {
                    res[i] = points[(int)j[0]];
                    //为了防止重复，记录完的赋值-1
                    j[1] = -1.0;
                    break;
                }
            }
        }
        return res;
    }
}
