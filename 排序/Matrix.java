package 排序;

import java.util.*;
public class Matrix {
    public static void main(String[] args) {
        int[][] m = {{1,2,3,4,5},{2,4,5,8,10}, {4,5,7,9,11},{1,4,5,7,9}};
        int[][] n = {{},{},{},{}};
        int[][] n1 = {{1,2,3}};
        int[][] n2 = {{1,1,1,1}};
        int[][] m1 = {{1,2,3},{4,5,6}};
        int[][] multiple = {{1,2,3},{1,2,4},{1,2,5}};
        int[][] last = {{1,2,6}, {3,4,6},{3,5,6}};
        System.out.println(findMin(n));
    }

    public static int findMin(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(map.containsKey(mat[i][j])) {
                    map.put(mat[i][j], map.get(mat[i][j]) + 1);
                }
                else {
                    map.put(mat[i][j], 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;

        for(int key : map.keySet()) {
            if(map.get(key) == mat.length) {
                res = Math.min(res, key);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
