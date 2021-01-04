package 不知名类型;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Zhonghua {
    public static void main(String[] args) {
        int[] f = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(f,1));
        System.out.println(canPlaceFlowers(f,2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] f = new int[flowerbed.length + 2];
        //将首尾添0可以省去边界值判断
        for(int i = 1; i < f.length - 1; i++) {
            f[i] = flowerbed[i - 1];
        }
        f[0] = 0;
        f[f.length - 1] = 0;

        /*
        每连续三个0可以种一朵花
         */
        int count = 0;
        for(int i = 1 ; i < f.length - 1; i++) {
            if(f[i-1] == 0 && f[i] == 0 && f[i+1] == 0) {
                count++;
                f[i] = 1;
            }
        }
        return count >= n;
    }
}
