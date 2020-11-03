package 二分法;
/*
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 */

public class isSquare {
    public static void main(String[] args) {
        int num = 808201;
        System.out.println(isPerfectSquare(4));
    }

    /*
    通过二分法寻找是否有数值可以平方后得到结果
     */
    public static boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long i = 0, j = num / 2;
        long sq = 0;
        while(i <= j) {
            long m = i +(j - i) / 2;
            sq = m * m;
            if(sq == num) return true;
            if(sq < num) i = m + 1;
            else j = m - 1;
        }
        //System.out.println(res*res + " " + num);

        return false;
    }
}
