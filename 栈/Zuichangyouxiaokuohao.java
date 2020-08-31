package 栈;

import java.util.Stack;
/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
/*
用栈。
设一个初始分割坐标-1。
当遍历到'（'时，将当前坐标入栈，
当遍历到'）'时，将栈最上层的弹出：1、若前面有左括号，意味着组成了一对括号。
2、若前面没有左括号，出栈的是上一个没有被匹配到的右括号。
若弹出后为空，则代表该位置是新的没被匹配到的右括号，将该坐标入栈。
若不为空，则代表该位置是新匹配到的右括号，用该位置坐标-栈的最上面的值，得出当前最长有效括号。
 */

public class Zuichangyouxiaokuohao {
    public static void main(String[] args) {
        String s = "())(())";

        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses2(s));
    }
    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    /*
    方法2。新建数组记录无法匹配的括号的位置。
    不能匹配的位置记为1，统计最长0的长度。
     */
    public static int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(i);  //记录左括号
            else {
                if(stack.isEmpty()) mark[i] = 1;  //若栈为空，则说明没有记录的左括号，将该位置标记为1
                else stack.pop();  //匹配到左括号，将左括号弹出
            }
        }

        while(!stack.isEmpty()) {
            mark[stack.peek()] = 1;  //没有匹配到的右括号记为1
            stack.pop();
        }

        int len = 0;
        for(int i = 0; i < mark.length; i++) {  //寻找最长连续0
            //System.out.println(mark[i]);
            if(mark[i] == 0) len++;
            else {
                max = Math.max(max, len);
                len = 0;
            }
        }
        max = Math.max(max, len);

        return max;
    }
}
