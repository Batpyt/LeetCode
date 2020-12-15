package 不知名类型;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IncreasingDigit {
    public static void main(String[] args) {
        int N = 1234;
        System.out.println(monotoneIncreasingDigits(N));
    }

    /*
    从右往左遍历，若左边的比右边的大则将左边的-1并将其右边都设为9
     */
    public static int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] c = s.toCharArray();
        int length = c.length;
        //position记录最后一个-1的位置，他右边都设为9
        int position = length;
        for(int i = length - 1; i >= 1; i--) {
            //132 -> 129
            if(c[i] < c[i - 1]) {
                position = i;
                c[i - 1]--;
            }
        }

        for(int i = position; i < length; i++) {
            c[i] = '9';
        }

        return Integer.parseInt(new String(c));
    }
}
