package 排序;

import java.util.Arrays;

public class Shuzupingfang {
    public static void main(String[] args) {
        int[] A = {-4,-1,0,3,10};
        int[] res = sortedSquares(A);
        for(int num : res) {
            System.out.println(num);
        }
    }

    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }
}
