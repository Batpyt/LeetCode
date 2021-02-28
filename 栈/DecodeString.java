package 栈;

import java.util.Stack;

/**
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            //当前字符为"]"，在栈中找到[]内的字符串
            if(s.charAt(i) == ']') {
                String string = "";
                while(!stack.peek().equals("[")) {
                    string = stack.pop() + string;
                }
                //将"["弹出
                stack.pop();

                //"["的前面的数字即为重复的次数，记录
                String counts = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    counts = stack.pop() + counts;
                }
                int count = Integer.parseInt(counts);

                //重复相应次数
                String temp = "";
                for(int j = 0; j < count; j++) {
                    temp += string;
                }
                //重复完后，再次加入栈中
                stack.push(temp);
            }
            //一般情况，直接入栈
            else {
                stack.push(s.charAt(i)+"");
            }
        }

        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        return res;
    }
}
