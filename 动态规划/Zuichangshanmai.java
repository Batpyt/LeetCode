package 动态规划;

import sun.nio.cs.ext.MacThai;

public class Zuichangshanmai {
    public static void main(String[] args) {
        int[] A = {2,1,4,7,3,2,5};
        int[] a = {2,2,2};
        System.out.println(longestMountain(a));
    }

    public static int longestMountain(int[] A) {
        if(A == null || A.length < 3) return 0;

        int res = 0;
        for(int i = 1; i < A.length - 1 ; i++) {
            if(A[i - 1] < A[i] && A[i] > A[i + 1]) {
                int l = i - 1;
                int r = i + 1;

                while(l > 0 && A[l - 1] < A[l]) l--;
                while(r < A.length - 1 && A[r + 1] < A[r]) r++;

                res = Math.max(res, (r - l + 1));
            }

        }
        return res;
    }
}
