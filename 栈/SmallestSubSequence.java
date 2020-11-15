package 栈;

import java.util.Stack;

/**
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * 示例 1：
 * 输入："cdadabcc"
 * 输出："adbc"
 *
 * 示例 2：
 * 输入："abcd"
 * 输出："abcd"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SmallestSubSequence {
    public static void main(String[] args) {
        String s = "cdadabcc";
        System.out.println(smallestSubsequence(s));
    }

    /**
     * 单调栈解决，若新遍历到的元素字典序小于栈顶元素，弹出栈顶。
     * 若新遍历到的在栈中已经存在，跳过这次循环
     */
    public static String smallestSubsequence(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            //若已经存在，跳过
            if(stack.contains(c)) continue;

            //当栈顶大于当前元素，弹出
            //同时要保证弹出的元素在字符串后面中出现了
            while(!stack.isEmpty() && c < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
