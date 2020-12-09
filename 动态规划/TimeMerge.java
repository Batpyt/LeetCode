package 动态规划;

import java.util.*;

/**
 * 合并数组
 * [1,3][2,4][5,6] -> [1,6]
 */

public class TimeMerge {
    public static void main(String[] args) {
        int[][] time = {{2,4},{1,3},{8,10}};
        int[][] res = timeMerge(time);
        for(int[] r : res) {
            for(int i : r) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static int[][] timeMerge(int[][] time) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                else {
                    return o1[0] -o2[0];
                }
            }
        });

//        for(int[] r : time) {
//            for(int i : r) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }

        int left = time[0][0];
        int right = time[0][1];
        for(int i = 1; i < time.length; i++) {
            //13 24 56
            //[1,3][4,5]
            if(right < time[i][0] - 1) {
                int[] add = {left,right};
                res.add(add);
                left = time[i][0];
                right = time[i][1];
            }

            //[1,3][2,4]
            //[1,3][1,4]
            if(left <= time[i][0]) {
                right = Math.max(right, time[i][1]);
            }
        }
        int[] add = {left,right};
        res.add(add);
        return res.toArray(new int[res.size()][2]);
    }
}
