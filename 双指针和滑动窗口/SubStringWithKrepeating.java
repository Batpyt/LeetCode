package 双指针和滑动窗口;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubStringWithKrepeating {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    public static int longestSubstring(String s, int k) {
        int res = 0;
        //字符串中有多少个不同的数，从1个到26个，从中取最大值
        for(int i = 0; i <= 26; i++) {
            int left = 0, right = 0;
            //记录每个字符出现多少次
            int[] count = new int[26];
            //记录出现过的字符的数量
            int counti = 0;
            //less记录有多少个出现的字符出现了不到k次
            int less = 0;
            //右指针右移
            while(right < s.length()) {
                //记录当前出现的字符
                count[s.charAt(right) - 'a']++;
                //若字符出现1次，即为第一次出现，less++
                if(count[s.charAt(right) - 'a'] == 1) {
                    counti++;
                    less++;
                }
                //当字符出现够了k次，less--；
                if(count[s.charAt(right) - 'a'] == k) {
                    less--;
                }

                //当出现的字符数量大于i
                //左指针右移
                while(counti > i) {
                    //若当前左指针指向的字符正好出现k次，右移后该字符将出现不足k次，less++
                    if(count[s.charAt(left) - 'a'] == k) {
                        less++;
                    }
                    //若当前指向的只出现了1次，该字符将不出现，less--，counti--；
                    if(count[s.charAt(left) - 'a'] == 1) {
                        less--;
                        counti--;
                    }
                    //指针右移
                    count[s.charAt(left) - 'a']--;
                    left++;
                }
                //如果当前字符串中的字符都出现了k次以上，记录更大的结果
                if(less == 0) {
                    res = Math.max(res, right - left + 1);
                }
                //右指针右移
                right++;
            }
        }
        return res;
    }
}
