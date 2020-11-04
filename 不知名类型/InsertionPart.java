package 不知名类型;

import java.util.ArrayList;
import java.util.List;
/*
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 

示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class InsertionPart {
    public static void main(String[] args) {
        InsertionPart i = new InsertionPart();
        int[][] intervals = {{1,3}, {6,9}};
        int[] newinterval = {2,5};
        int[][] res = i.insert(intervals, newinterval);
        for(int[] r : res) {
            for(int e : r) {
                System.out.print(e);
            }
            System.out.println();
        }

    }

    /*
    判断插入区间再已存在区间的左边、右边或者合并区间
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        //判断插入区间是否已经入列
        boolean in = false;

        //创建一个列表来记录新的区间列表
        List<int[]> l = new ArrayList<>();
        for(int[] interval : intervals) {
            //[, interval1][left, ]
            //如果插入区间的左边大于当前已存在区间的右边，说明插入区间在当前区间的右边
            //将当前区间加入新的区间列表
            if(interval[1] < left) {
                l.add(interval);
            }

            //[, right][interval0, ]
            //如果插入区间的右边小于当前区间的左边，插入区间在当前区间左边
            else if(interval[0] > right) {
                //若插入区间还没入列，将插入区间入列
                if(!in) {
                    l.add(new int[]{left, right});
                    in = true;
                }
                //再将已有区间加入新区区间
                l.add(interval);
            }

            //其他情况时候，插入区间要与已有区间合并。
            else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        //[][][][][][left, right]
        if(!in) {
            l.add(new int[]{left, right});
        }
        int[][] res = new int[l.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }

}
