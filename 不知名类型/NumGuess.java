package 不知名类型;

import java.util.*;

/**
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 *
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NumGuess {
    public static void main(String[] args) {
        String s = "1807";
        String g = "7810";
        System.out.println(getHint("11", "10"));
    }

    /*
    将位置和数字都相等的记录，同时记录每个数字出现了多少次
     */
    public static String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int A = 0;
        int B = 0;

        for(int i = 0; i < secret.length(); i++) {
            //记录每个数字一共出现多少次
            s[secret.charAt(i) - '0']++;
            g[guess.charAt(i) - '0']++;
            //统计位置和数字都一样的位数
            if(secret.charAt(i) == guess.charAt(i)) A++;
        }

        //再统计有多少数字一样位置不一样
        for(int i = 0; i < 10; i++) {
            //若在两字符串中出现次数>0,取较小的那个
            if(g[i] > 0 && s[i] > 0) B = B + Math.min(s[i], g[i]);
        }
        //返回时B要减去A
        return A+"A"+(B-A)+"B";
    }
}
