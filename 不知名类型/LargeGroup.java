package 不知名类型;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LargeGroup {
    public static void main(String[] args) {
        //String s = "abcdddeeeeaabbbcd";
        String s = "aaa";
        System.out.println(largeGroupPositions(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        //结尾加一个数字处理边界问题
        s = s + "1";
        List<List<Integer>> res = new ArrayList<>();
        //记录有几个连续一样的，起始为一个
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            //若与前一位一样则加一
            if(s.charAt(i) == s.charAt(i - 1)) {
                count++;
                System.out.println(count+" "+s.charAt(i) + s.charAt(i-1));
            }
            //若不一样，则判断是否大于等于3，若是，则记录
            else {
                if(count >= 3) {
                    System.out.println(i-count + " "+i);
                    List<Integer> list = new ArrayList<>();
                    list.add(i - count);
                    list.add(i - 1);
                    res.add(list);
                }
                //将count变回1
                count = 1;
            }
        }
        return res;
    }
}
