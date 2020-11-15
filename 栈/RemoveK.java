package 栈;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RemoveK {
    public static void main(String[] args) {
        String num = "1432219";
        RemoveK k = new RemoveK();
        System.out.println(k.removeKdigits(num, 3));
    }

    /**
     * 思路：单调栈，若新遍历到的元素小于栈顶，则将栈顶弹出直到栈顶小于新元素
     */
    public String removeKdigits(String num, int k) {
        if(k >= num.length() || num.length() == 0) return "0";

        Stack<Integer> s = new Stack<>();
        s.push(num.charAt(0) - '0');

        //遍历所有元素
        for(int i = 1; i < num.length(); i++) {
            int now = num.charAt(i) - '0';

            //若当前栈顶大于遍历到的元素，且栈不为空，k>0，弹出栈顶
            while(!s.isEmpty() && k > 0 && now < s.peek()) {
                s.pop();
                k--;
            }
            //当元素不为0或栈不为空时压入栈
            if(now != 0 || !s.isEmpty()) {
                s.push(now);
            }
        }

        //若没有删完k个却已经遍历完了，例如：56789，后面的都比前面的大。直接从后往前出栈。
        while(k > 0) {
            s.pop();
            k--;
        }
        if(s.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }

        //将出栈的倒叙返回
        return sb.reverse().toString();
    }
}
