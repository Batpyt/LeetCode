package 动态规划;

import java.util.*;

public class RightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{1,2}};

    }

    public static int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> map = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] res = new int[intervals.length];
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 0; i < intervals.length - 1; i++) {
            //13 24
            //13 34
            if(intervals[i][1] >= intervals[i + 1][0]) {
                //定位到当前区间索引位置
                int index = map.get(intervals[i]);
                res[index] = map.get(intervals[i + 1]);
            }
        }
        return res;
    }
}
