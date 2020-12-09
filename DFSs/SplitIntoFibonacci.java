package DFSs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SplitIntoFibonacci {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("11235813"));
    }

    /*
    dfs+剪枝
     */
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(res, S, S.length(),0,0,0);
        return res;
    }

    /**
     *
     * @param res 存为列表的数列
     * @param s 待分割字符串
     * @param length 字符串长度
     * @param index 当前dfs搜索起始位置
     * @param expect 当前搜索的数字目标值 F[n]
     * @param prev 前一个值F[n-1]
     * @return
     */
    public static boolean dfs(List<Integer> res, String s, int length, int index, int expect, int prev) {
        //当所有数字都遍历完时，检查链表是否有三个元素，只有三个以上元素才构成斐波那契数列
        if(index == length) return res.size() >= 3;
        long curlong = 0;

        //从当前搜索起始位置开始搜索
        for(int i = index; i < length; i++) {
            //若起始位置为0且不是个位数，直接跳出，剪枝
            if(i > index && s.charAt(index) == '0') break;

            curlong = curlong * 10 + s.charAt(i) - '0';
            //不能超过int最大值
            if(curlong > Integer.MAX_VALUE) break;

            int cur = (int)curlong;
            //当数数列大小已经>=2
            if(res.size() >= 2) {
                //若搜索结果小于目标值，直接开始下一循环，多给一位数
                if(cur < expect) continue;

                //若搜索结果大，直接跳出
                else if(cur > expect) break;
            }

            res.add(cur);
            //若递归返回true，index+1，目标值更新，开始新的遍历
            if(dfs(res, s, length, i + 1, prev + cur, cur)) return true;
            else res.remove(res.size() - 1);


        }
        return false;
    }

}
