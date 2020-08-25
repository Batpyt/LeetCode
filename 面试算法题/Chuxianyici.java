package 面试算法题;
/*
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
/*
通过位运算，先通过异或运算，求出两个数的异或结果。
然后求出最小的这两个数异或结果为1的那位（mask）。
再通过在此位为1或为0进行分组，分别异或，相同的数异或为0，所以得到的两个数就是答案。
 */

public class Chuxianyici {
    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        for(int i : singleNumbers(nums)) {
            System.out.println(i);
        }
    }

    public static int[] singleNumbers(int[] nums) {
        int k = 0;
        for(int num : nums) {
            k = k ^ num;
        }

        int mask = 1;
        while((k & mask) == 0) {  //得到最小的异或结果为1的位置
            mask = mask << 1;
        }

        int a = 0;
        int b = 0;

        for(int num : nums) {  //分为两组分别异或
            if((num & mask) == 0) {
                a = a ^ num;
            }
            else {
                b = b ^ num;
            }
        }

        return new int[] {a,b};
    }
}
