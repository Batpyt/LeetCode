package 动态规划;
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 */
/*
经典斐波那契数列。
 */

public class Tiaotaijie {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        int sum = 0;
        int a = 0;
        int b = 1;
        for(int i = 0; i < n; i++) {
            sum = a + b; //a = f(n - 2), b = f(n - 1), sum = f(n)
            a = b;  // a = f(n - 1)
            b = sum;  //b = f(n)
        }
        return sum;
    }
}
