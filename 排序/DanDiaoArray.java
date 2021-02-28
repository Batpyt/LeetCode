package 排序;

public class DanDiaoArray {
    public static void main(String[] args) {
        int[] n = {1,2,2,3};
        int[] m = {1,3,2};
        System.out.println(isMonotonic(n));
        System.out.println(isMonotonic(m));
    }

    public static boolean isMonotonic(int[] A) {
        boolean up = false, down = false;
        for(int i = 0 ; i < A.length - 1; i++) {
            if(A[i] > A[i+1]) {
                down = true;
            }
            if(A[i] < A[i+1]) {
                up = true;
            }
            if(up && down) {
                return false;
            }
        }
        return true;
    }
}
