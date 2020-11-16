package 不知名类型;
/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Palindrome {
    public static void main(String[] args) {
        String s = "asddasasdas";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome("ccc"));
    }

    /*
    统计出现次数，偶数都加起来，奇数的-1再加。最后，如果有出现过奇数，结果再加1，当作中间的字符
     */
    public static int longestPalindrome(String s) {
        int res = 0;

        //大小字符一共横跨了58位
        int[] count = new int[58];
        for(char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        //用来记录是否有奇数出现
        boolean flag = false;
        for(int i : count) {
            //如果是偶数，直接加
            if(i % 2 == 0) {
                res = res + i;
            }
            //若是奇数，-1再加
            else {
                flag = true;
                res = res + i - 1;
            }
        }

        //如果出现过了奇数，结果在+1
        if(flag) res++;
        return res;
    }
}
